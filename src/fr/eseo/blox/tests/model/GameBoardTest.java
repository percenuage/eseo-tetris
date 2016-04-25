package fr.eseo.blox.tests.model;

import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.model.ZPiece;

public class GameBoardTest {

	public static void main(String[] args) {
		GameBoardTest gbt = new GameBoardTest();
		gbt.testConstructor();
		gbt.testConstructorWidthHeight();
		gbt.testWidthAccessors();
		gbt.testHeightAccessors();
		gbt.testCurrentPieceAccessors();
		gbt.testNewPieceAccessors();
		gbt.testPileAccessors();
		gbt.testAsciiArt();
		gbt.testHandleCollision();
		gbt.testGravity();
		gbt.testGravityWithException();
		gbt.testGravityWithCheck();

	}
	
	public void testConstructor() {
		GameBoard gb = new GameBoard();
		System.out.println(gb.toString());
		System.out.println();
	}
	
	public void testConstructorWidthHeight() {
		GameBoard gb = new GameBoard(15,45);
		System.out.println(gb.toString());
		System.out.println();
	}
	
	public void testWidthAccessors() {
		GameBoard gb = new GameBoard();
		gb.setWidth(15);
		System.out.println("GetterWidth : "+gb.getWidth());
		System.out.println();
	} 
	
	public void testHeightAccessors() {
		GameBoard gb = new GameBoard();
		gb.setHeight(30);
		System.out.println("GetterHeight : "+gb.getHeight());
		System.out.println();
	} 
	
	public void testCurrentPieceAccessors() {
		GameBoard gb = new GameBoard();
		gb.setCurrentPiece(PieceFactory.newPiece(gb));
		System.out.println("GetterCurrentPiece : "+gb.getCurrentPiece());
		System.out.println();
	}
	
	public void testNewPieceAccessors() {
		GameBoard gb = new GameBoard();
		gb.setNextPiece(PieceFactory.newPiece(gb));
		System.out.println("GetterNextPiece : "+gb.getNextPiece());
		System.out.println();
	}
	
	public void testPileAccessors() {
		GameBoard gb = new GameBoard();
		gb.setPile(new Pile(gb));
		System.out.println("GetterPile : "+gb.getPile());
		System.out.println();
	}
	
	public void testAsciiArt() {
		GameBoard gb = new GameBoard();
		gb.setCurrentPiece(new ZPiece(2, 3));
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testHandleCollision() {
		GameBoard gb = new GameBoard();
		gb.setPile(new Pile(gb, 12, 2));
		gb.setCurrentPiece(new ZPiece(2, 5));
		gb.setNextPiece(PieceFactory.newPiece(gb));
		
		System.out.println(gb.toString());
		System.out.println(gb.getAsciiArt());
		gb.handleCollision();
		System.out.println(gb.toString());
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testGravity() {
		GameBoard gb = new GameBoard();
		gb.setPile(new Pile(gb, 5));
		gb.setCurrentPiece(new ZPiece(2, 2));
		System.out.println("Test Gravity");
		System.out.println(gb.getAsciiArt());
		gb.gravity();
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testGravityWithException() {
		GameBoard gb = new GameBoard();
		gb.setPile(new Pile(gb, 5));
		gb.setCurrentPiece(new ZPiece(4, 5));
		System.out.println("Test Gravity With Collision");
		System.out.println(gb.getAsciiArt());
		gb.gravity();
		gb.gravity();
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testGravityWithCheck() {
		GameBoard gb = new GameBoard();
		gb.setPile(new Pile(gb, 15, 2));
		gb.setCurrentPiece(new ZPiece(4, 4));
		System.out.println("Test Gravity With Check Full Rows");
		System.out.println(gb.getAsciiArt());
		gb.gravity();
		gb.gravity();
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	
}
