package fr.eseo.blox.model;

public class GameBoard {

	public static final int DEFAULT_WIDTH = 6;
	public static final int DEFAULT_HEIGHT = 8;
	
	private int width;
	private int height;
	
	private Piece nextPiece;
	private Piece currentPiece;
	private Pile pile;
	
	public GameBoard() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public GameBoard(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(Piece piece) {
		if (piece != null) {
			piece.setGameBoard(this);
		}
		this.currentPiece = piece;	
	}

	public Piece getNextPiece() {
		return nextPiece;
	}

	public void setNextPiece(Piece newPiece) {
		newPiece.setGameBoard(this);
		if(nextPiece == null){
			this.nextPiece = newPiece;
		}else{
			setCurrentPiece(nextPiece); //CurrentPiece se change en NextPiece
			this.nextPiece = newPiece;
		}		
	}

	public Pile getPile() {
		return pile;
	}

	public void setPile(Pile pile) {
		this.pile = pile;
	}

	public String toString() {
		return "GameBoard : Dimension (" + width + "," + height + "), current piece : "
				+ currentPiece + ", next piece : " + nextPiece;
	}

	public String getAsciiArt() {
		char[][] ascii = new char[width][height];
	
		/* Affichage de la Pile (O) + des espace vide (.) */
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(pile != null && pile.getElements()[j][i] != null){ //L'existence de la pile est requise sinon QR code !
					ascii[j][i] = 'O';
				}else{
					ascii[j][i] = '.';
				}
			}
		}
		
		/* Affichage de la Piece (X) */
		if (currentPiece != null) { //Si la piece n'existe pas = Big erreur = prof :( = Moi :'( (cas o� la pile est appeler)
			for (int i = 0; i < 4; i++) {
				if (currentPiece.getElements().get(i).getY() >= 0) {
					ascii[currentPiece.getElements().get(i).getX()]
						 [currentPiece.getElements().get(i).getY()] = 'X';
				}
			}
		}	
		
		/* Le tout dans un string */
		String s = new String();	
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				s += ascii[j][i];
			}
			s += "\n";
		}
		return s;
	}
	
	public void handleCollision() {
		if(this.getCurrentPiece() != null && this.getPile() != null) {
			try {
				this.getPile().addElements(this.getCurrentPiece());
				currentPiece = null;
			} catch(ArrayIndexOutOfBoundsException out) {
				throw new ArrayIndexOutOfBoundsException();//à éviter
			}
				
			this.getPile().checkFullRows();
			setNextPiece(PieceFactory.newPiece(this));	
		}
	}
	
	public boolean gravity() throws IllegalArgumentException{
		if(this.getCurrentPiece() != null && this.getPile() != null){
			try {
				currentPiece.moveBy(0, 1);
				return false;
			} catch (BloxException e) {
				System.err.println(e.getMessage());
				this.handleCollision();
				return true;
			}
		} else {
			return false;
		}
	}
}
