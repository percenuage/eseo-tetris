package fr.eseo.blox;

import java.awt.Color;
import fr.eseo.blox.model.*;


public class ESEO {
	
	private GameBoard gameBoard;
        private Pile pile;
	
	public ESEO(GameBoard gb, int posX, int posY) throws BloxException {
		gameBoard = gb;
		gameBoard.setPile(new Pile(gameBoard));	
        this.letterE(posX, posY, Color.BLUE);
		this.letterS(posX + 6, posY + 5, Color.BLUE);
		this.letterE(posX, posY + 10, Color.BLUE);
		this.letterO(posX + 6, posY + 15, Color.BLUE);
	}
	
	public void letterE(int x, int y, Color colour) throws BloxException {
		TPiece tp = new TPiece(x, y, colour);
		IPiece ip1 = new IPiece(x + 1, y + 2, colour);
		IPiece ip2 = new IPiece(x + 1, y - 2, colour);
		tp.rotatePiece(false);
		ip1.rotatePiece(true);
		ip2.rotatePiece(true);
		gameBoard.getPile().addElements(tp);
		gameBoard.getPile().addElements(ip1);
		gameBoard.getPile().addElements(ip2);
		
	}
	
	public void letterS(int x, int y, Color colour) throws BloxException {
		LPiece lp = new LPiece(x, y, colour);
		JPiece jp = new JPiece(x + 3, y, colour);
		IPiece ip1 = new IPiece(x + 1, y + 2, colour);
		IPiece ip2 = new IPiece(x + 1, y - 2, colour);
		jp.rotatePiece(false);
		ip1.rotatePiece(true);
		ip2.rotatePiece(true);
		gameBoard.getPile().addElements(lp);
		gameBoard.getPile().addElements(jp);
		gameBoard.getPile().addElements(ip1);
		gameBoard.getPile().addElements(ip2);
	}
	
	public void letterO(int x, int y, Color colour) throws BloxException {
		IPiece ip1 = new IPiece(x, y, colour);
		IPiece ip2 = new IPiece(x + 1, y + 2, colour);
		JPiece jp1 = new JPiece(x + 3, y - 2, colour);
		JPiece jp2 = new JPiece(x + 3, y + 2, colour);
		ip2.rotatePiece(true);
		jp1.rotatePiece(false);
		gameBoard.getPile().addElements(ip1);
		gameBoard.getPile().addElements(ip2);
		gameBoard.getPile().addElements(jp1);
		gameBoard.getPile().addElements(jp2);
	}
	/*
	public static void main(String[] args) throws BloxException {		
		GameBoardPanel gbp = new GameBoardPanel();
		new ESEO(gbp.getGameBoard(), 0, 2);
		
		new ViewPile(gbp);
		new BloxFrame("BloxGame", gbp);
		
		//ESEO e = new ESEO(new GameBoard(24, 10), 1, 7);
		//System.out.println(e.gameBoard.getAsciiArt());
	}
	*/

    public Pile getPile() {
        return pile;
    }

    public void setPile(Pile pile) {
        this.pile = pile;
    }

}
