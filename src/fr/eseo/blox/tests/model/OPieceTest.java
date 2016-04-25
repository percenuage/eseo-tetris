package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.OPiece;
import fr.eseo.blox.model.Pile;

public class OPieceTest {

	public static void main(String[] args) {
		OPieceTest zpt= new OPieceTest();
		//Test constructeurs
		zpt.testConstructorPoint();
		zpt.testConstructorXY();
		zpt.testConstructorXYColour();
		zpt.testConstructorXYPoint();
		//Test accesseurs
		zpt.testOPieceAccessors();
		//Test methodes
		zpt.testOPieceAscii();
		zpt.testOPieceRotate(true);
		zpt.testMoveBy();
		zpt.testMoveByWithPile();
	}
	
	public void testConstructorPoint(){
		OPiece zp = new OPiece(new Point());
		System.out.println("Coordonnees OPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXY(){
		OPiece zp = new OPiece(2,3);
		System.out.println("Coordonnees OPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYColour(){
		OPiece zp = new OPiece(1,3,Color.BLACK);
		System.out.println("Coordonnees OPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYPoint(){
		OPiece zp = new OPiece(new Point(5,4),Color.BLACK);
		System.out.println("Coordonnees OPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testOPieceAccessors(){
		OPiece zp = new OPiece(0,0);
		System.out.println("Elements : "+zp.getElements());
		System.out.println();
	}
	
	public void testOPieceAscii(){
		OPiece zp = new OPiece(0,0);	
		System.out.println(zp.getAsciiArt());
	}
	
	public void testOPieceRotate(boolean bool){
		OPiece zp = new OPiece(2, 3);
		
		zp.setGameBoard(new GameBoard());
		zp.getGameBoard().setCurrentPiece(zp);
		zp.getGameBoard().setPile(new Pile(zp.getGameBoard(),10,4));
		
		System.out.println("Test Rotation");
		System.out.println(zp.getGameBoard().getAsciiArt());
		
		zp.rotatePiece(bool);

		System.out.println(zp.getGameBoard().getAsciiArt());
		System.out.println();
	}
	
	public void testMoveBy(){
		OPiece zp = new OPiece(2, 3); //Test non valide en (0 ; 0)
		
		zp.setGameBoard(new GameBoard());
		zp.getGameBoard().setCurrentPiece(zp);
		zp.getGameBoard().setPile(new Pile(zp.getGameBoard()));
		
		System.out.println("Test Déplacement Sans Pile");
		System.out.println(zp.getGameBoard().getAsciiArt());
		
		try{
			System.out.println("Vers La Droite");
			zp.moveBy(1, 0);	//Test valide
			System.out.println(zp.getGameBoard().getAsciiArt());
			System.out.println("Vers Le Haut");
			zp.moveBy(0, -1);	//Test invalide	
			System.out.println(zp.getGameBoard().getAsciiArt());
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage()); //Affiche message erreur
		}catch (BloxException e1) {
			System.err.println(e1.getMessage());
		}
		
			
		System.out.println();
	}
	
	public void testMoveByWithPile(){
		OPiece zp = new OPiece(2, 3); //Test non valide en (0 ; 0)
		
		zp.setGameBoard(new GameBoard());
		zp.getGameBoard().setCurrentPiece(zp);
		zp.getGameBoard().setPile(new Pile(zp.getGameBoard(),10,4));
		
		System.out.println("Test Déplacement Avec Pile");
		System.out.println(zp.getGameBoard().getAsciiArt());
		
		try{
			System.out.println("Vers Le Bas");
			zp.moveBy(0, 1);	//Test potentiellement invalide (pile aléatoire)
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage()); //Affiche message erreur
		}catch (BloxException e1) {
			System.err.println(e1.getMessage());
		}
		
		System.out.println(zp.getGameBoard().getAsciiArt());	
		System.out.println();
	}

}
