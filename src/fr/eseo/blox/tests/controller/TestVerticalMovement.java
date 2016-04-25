package fr.eseo.blox.tests.controller;

import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.GameBoardPanel;
import fr.eseo.blox.view.ViewPiece;

public class TestVerticalMovement {

	public static void main(String[] args) {
		TestVerticalMovement tvm = new TestVerticalMovement();
		tvm.testPieceVerticalMovement();
	}
	
	public void testPieceVerticalMovement() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.getGameBoard().setCurrentPiece(PieceFactory.newPiece(gbp.getGameBoard()));
		for (int i = 0; i < 4; i++) {
		    System.out.println(gbp.getGameBoard());
			gbp.getGameBoard().gravity();
		}
		System.out.println(gbp.getGameBoard().getAsciiArt());
		new ViewPiece(gbp);
		new BloxFrame("Test Avec Piece", gbp);
	}
	
}
