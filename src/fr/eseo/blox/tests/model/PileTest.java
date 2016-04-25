package fr.eseo.blox.tests.model;

import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.model.ZPiece;

public class PileTest {

	public static void main(String[] args) {
		PileTest pt = new PileTest();
		/*pt.testConstructorGB();
		pt.testConstructorGBElement();
		pt.testConstructorGBElementRows();*/
		pt.testPileAccessors();
		/*pt.testAddElements();
		pt.testCheckFullRows();
		pt.testCheckFullRows2();
		pt.testCheckFullRows3();*/
	}
	
	public void testConstructorGB() {
		Pile p = new Pile(new GameBoard());
		System.out.println(p.getAsciiArt());
		System.out.println();
	}
	
	public void testConstructorGBElement() {
		Pile p = new Pile(new GameBoard(), 10);	
		System.out.println(p.getAsciiArt());
		System.out.println();
	}
	
	public void testConstructorGBElementRows() {
		Pile p = new Pile(new GameBoard(), 100, 4);
		System.out.println(p.getAsciiArt());
		System.out.println();
	}
	
	public void testPileAccessors() {
		Pile p = new Pile(new GameBoard(), 10, 5);
		System.out.println(p.getAsciiArt());
		p.setGameBoard(new GameBoard(13, 5)); //Ici potentielle erreur changement de GB => Non corrigé	
		System.out.println(p.getAsciiArt()); // Si gameBoard1 != gameBoard2 ? 
		System.out.println(p.getGameBoard());
		System.out.println(p.getElements());
		System.out.println();
	}
	
	public void testAddElements() {
		GameBoard gb = new GameBoard();
		Pile p = new Pile(gb, 10);
		gb.setCurrentPiece(new ZPiece(3, 1));	
		System.out.println(gb.getAsciiArt());
		p.addElements(new ZPiece(2, 4));
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testCheckFullRows() { 
		GameBoard gb = new GameBoard();
		Pile p = new Pile(gb, 28, 5);
		System.out.println("Pile with 5 rows");
		System.out.println(gb.getAsciiArt());
		int val = p.checkFullRows();
		System.out.println("Lignes supprimé : "+val);
		System.out.println(gb.getAsciiArt());
		System.out.println();
		
	}
	
	public void testCheckFullRows2() {
		GameBoard gb = new GameBoard();
		Pile p = new Pile(gb, 50, 8);
		System.out.println("Full Pile");
		System.out.println(gb.getAsciiArt());
		p.checkFullRows();
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}
	
	public void testCheckFullRows3() {
		GameBoard gb = new GameBoard();
		Pile p = new Pile(gb);
		System.out.println("None Pile");
		System.out.println(gb.getAsciiArt());
		p.checkFullRows();
		System.out.println(gb.getAsciiArt());
		System.out.println();
	}

}
