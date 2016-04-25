package fr.eseo.blox.tests.view;

import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.GameBoardPanel;
import fr.eseo.blox.view.ViewPile;
import fr.eseo.blox.view.ViewPiece;

public class GameBoardPanelTest {

	public static void main(String[] args) {
		GameBoardPanelTest gbpt = new GameBoardPanelTest();
		gbpt.testConstructorDefault();
		gbpt.testConstructorGB();
		gbpt.testConstructorElementSize();
		gbpt.testConstructorGBElementSize();
		gbpt.testGBAccessors();
		gbpt.testElementAccessors();
		gbpt.testBloxFrameAccessors();
		gbpt.testViewPileAccessors();
		gbpt.testViewPieceAccessors();
		gbpt.testViewPile();
		gbpt.testViewPiece();
		gbpt.testViewPieceAndPile();
	}
	
	public void testConstructorDefault() {
		GameBoardPanel gbp = new GameBoardPanel();
		System.out.println(gbp.getGameBoard());
		System.out.println("ElementSize : "+gbp.getElementSize());
		System.out.println("PreferredSize : "+gbp.getPreferredSize());
		System.out.println();
	}
	
	public void testConstructorGB() {
		GameBoardPanel gbp = new GameBoardPanel(new GameBoard(4,10));
		System.out.println(gbp.getGameBoard());
		System.out.println("ElementSize : "+gbp.getElementSize());
		System.out.println("PreferredSize : "+gbp.getPreferredSize());
		System.out.println();
	}
	
	public void testConstructorElementSize() {
		GameBoardPanel gbp = new GameBoardPanel(20);
		System.out.println(gbp.getGameBoard());
		System.out.println("ElementSize : "+gbp.getElementSize());
		System.out.println("PreferredSize : "+gbp.getPreferredSize());
		System.out.println();
	}
	
	public void testConstructorGBElementSize() {
		GameBoardPanel gbp = new GameBoardPanel(new GameBoard(5,5), 20);
		System.out.println(gbp.getGameBoard());
		System.out.println("ElementSize : "+gbp.getElementSize());
		System.out.println("PreferredSize : "+gbp.getPreferredSize());
		System.out.println();
	}
	
	public void testGBAccessors() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.setGameBoard(new GameBoard(10,10));
		System.out.println("Accessor GB : "+gbp.getGameBoard());
		System.out.println();
	}
	
	public void testElementAccessors() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.setElementSize(5);
		System.out.println("Accessor Element : "+gbp.getElementSize());
		System.out.println();
	}
	
	public void testBloxFrameAccessors() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.setBloxFrame(new BloxFrame());
		System.out.println("Accessor BloxFrame : "+gbp.getBloxFrame());
		System.out.println();
	}
	
	public void testViewPileAccessors() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.setViewPile(new ViewPile(gbp));
		System.out.println("Accessor ViewPile : "+gbp.getViewPile());
		System.out.println();
	}
	
	public void testViewPieceAccessors() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.setViewPiece(new ViewPiece(gbp));
		System.out.println("Accessor ViewPiece : "+gbp.getViewPiece());
		System.out.println();
	}
	
	public void testViewPile() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.getGameBoard().setPile(new Pile(gbp.getGameBoard(), 20));		
		System.out.println(gbp.getGameBoard().getAsciiArt());
		new ViewPile(gbp);	
		new BloxFrame("Test Avec Pile", gbp);
	}
	
	public void testViewPiece() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.getGameBoard().setPile(new Pile(gbp.getGameBoard(), 0));
		gbp.getGameBoard().setCurrentPiece(PieceFactory.newPiece(gbp.getGameBoard()));
		System.out.println(gbp.getGameBoard().getAsciiArt());
		new ViewPile(gbp);
		new ViewPiece(gbp);
		new BloxFrame("Test Avec Piece", gbp);
	}
	
	public void testViewPieceAndPile() {
		GameBoardPanel gbp = new GameBoardPanel();
		gbp.getGameBoard().setPile(new Pile(gbp.getGameBoard(), 20));
		gbp.getGameBoard().setCurrentPiece(PieceFactory.newPiece(gbp.getGameBoard()));
		System.out.println(gbp.getGameBoard().getAsciiArt());
		new ViewPile(gbp);
		new ViewPiece(gbp);
		new BloxFrame("Test Avec Piece And Pile", gbp);
	}
	
}
