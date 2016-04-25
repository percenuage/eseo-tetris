package fr.eseo.blox.model;

import java.awt.Color;
import java.util.Random;

public class PieceFactory {
	
	private PieceFactory() {} 
	
	/* Chaque Piece aura sa couleur */
	public static Piece newPiece(GameBoard gameBoard) {
		Random rand = new Random();
		Piece piece;	
		switch(rand.nextInt(7)){
			
			case 0 :
			piece = new ZPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;
			
			case 1 :
			piece = new IPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

			case 2 :
			piece = new JPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

			case 3 :
			piece = new LPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

			case 4 :
			piece = new OPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

			case 5 :
			piece = new SPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

			default : 
			piece = new TPiece(gameBoard.getWidth()/2, -2, new Color(rand.nextInt()));
			break;

		}
		piece.setGameBoard(gameBoard);
		return piece;
	}
	
}
