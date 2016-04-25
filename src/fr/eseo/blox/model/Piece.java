
package fr.eseo.blox.model;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Point;

public abstract class Piece{

	/* ATTRIBUTS */
	private List<Element> elements = new ArrayList<Element>();
	private GameBoard gameBoard;

	/* CONSTRUCTEURS */
	public Piece(Point coordinate){	
		this.setElements(coordinate, Element.DEFAULT_ELEMENT_COLOUR);
	}
	
	public Piece(int x, int y){	
		this(new Point(x,y));
	}
	
	public Piece(Point coordinate, Color colour){	
		this.setElements(coordinate, colour);
	}
	
	public Piece(int x, int y, Color colour){	
		this(new Point(x,y), colour);
	}
	
	/* ACCESSEURS */
	public List<Element> getElements() {
		return this.elements;
	}
	
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	/* MUTATEURS */
	abstract protected void setElements(Point coordinate, Color pieceColour);
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	/* METHODES */
	public String toString() {
		return getClass().getSimpleName()+" : "+elements.get(0).toString()+" , "+elements.get(1).toString()+" , "
				+elements.get(2).toString()+" , "+elements.get(3).toString();
	}

	public String getAsciiArt(){
		char[][] ascii = new char[5][5];
		int x0 = elements.get(0).getX();
		int y0 = elements.get(0).getY();
		
		/* Initialise */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ascii[i][j]='.';
			}
		}
		/* Affichage de la Piece (X) */
		for (int i = 0; i < 4; i++) {
			ascii[elements.get(i).getY() - y0 + 2]
				 [elements.get(i).getX() - x0 + 2] = 'X'; //Inversion du X et du Y
		}
		/* Le tout dans un string avec (\n) */
		String s = new String();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				s += ascii[i][j];
			}
			s += "\n";
		}
		return s;
	}
	
	public void rotatePiece(boolean clockwise) throws BloxException {		
		int n = 0;
		int x0 = elements.get(0).getX();
		int y0 = elements.get(0).getY();

		for (int i = 0; i < 4; i++) {
			/* Changement de variable et centrage en (0;0) => coordonnées relatifs */
			int x = elements.get(i).getX() - x0; // x(i) - x(0)
			int y = elements.get(i).getY() - y0; // y(i) - y(0)
			int tmpX = x; //Variable tampon de x
			
			if (clockwise) {
				x = -y + x0;
				y = tmpX + y0;
			}else {
				x = y + x0;
				y = -tmpX + y0;	
			}

			if (gameBoard != null) {
				if (x >= gameBoard.getWidth()) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE RIGHT", BloxException.BLOX_LEFT_GAMEBOARD);
				}else if (x < 0) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE LEFT", BloxException.BLOX_LEFT_GAMEBOARD);	
				}else if (y >= gameBoard.getHeight()) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE BOTTOM", BloxException.BLOX_COLLISION); 
				}else if (y >= 0 && gameBoard.getPile() != null && gameBoard.getPile().getElements()[x][y] != null) {
					throw new BloxException("A COLLISION OCCURS WITH PILE", BloxException.BLOX_COLLISION);
				}else {
					n++;
				}
			}else {
				n = 4; //Pas de GB => la piece tourne quand même sinon QR code !
			}
		}
		
		/* Mise en rotation si aucune exception n'a été levée */
		if (n == 4) {
			for (int i = 0; i < 4; i++) {
				int x = elements.get(i).getX() - x0;
				int y = elements.get(i).getY() - y0; 
				int tmpX = x;
				
				if (clockwise) {
					x = -y + x0;
					y = tmpX + y0;
				}else {
					x = y + x0;
					y = -tmpX + y0;	
				}
				elements.get(i).setX(x);
				elements.get(i).setY(y);
			}
		}
	}		
	
	public void moveBy(int dx, int dy) throws IllegalArgumentException, BloxException {				
		int n = 0;
		
		for (int i = 0; i < 4; i++) {
			
			int x = elements.get(i).getX();
			int y = elements.get(i).getY();
			
			if (gameBoard != null) {
				if (x + dx >= gameBoard.getWidth()) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE RIGHT", BloxException.BLOX_LEFT_GAMEBOARD);
				}else if (x + dx < 0) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE LEFT", BloxException.BLOX_LEFT_GAMEBOARD);
				}else if (y + dy >= gameBoard.getHeight()) {
					throw new BloxException("ELEMENT EXIT FROM GAMEBOARD TO THE BOTTOM", BloxException.BLOX_COLLISION);
				}else if (y >= 0 && gameBoard.getPile() != null && gameBoard.getPile().getElements()[x + dx][y] != null) { 
					throw new BloxException("A COLLISION OCCURS TO THE LEFT/RIGHT", BloxException.BLOX_COLLISION);
				}else if (y + dy >= 0 && gameBoard.getPile() != null && gameBoard.getPile().getElements()[x][y + dy] != null) {
					throw new BloxException("A COLLISION OCCURS TO THE BOTTOM. PIECE STOPS", BloxException.BLOX_COLLISION);
				}else {
					n++;
				}
			}else {
				n = 4; //Pas de GB => la piece tourne quand même sinon QR code !
			}	
		}	
		
		/* Mise en mouvement si aucune exception n'a été levée */
		if (n == 4) {
			for (int i = 0; i < 4; i++) {
				elements.get(i).moveBy(dx, dy);
			}	
		}
	}

}
