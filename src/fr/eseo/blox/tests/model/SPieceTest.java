package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.model.SPiece;

public class SPieceTest {
	
	public static void main(String[] args) {
		SPieceTest zpt= new SPieceTest();
		//Test constructeurs
		zpt.testConstructorPoint();
		zpt.testConstructorXY();
		zpt.testConstructorXYColour();
		zpt.testConstructorXYPoint();
		//Test accesseurs
		zpt.testSPieceAccessors();
		//Test methodes
		zpt.testSPieceAscii();
		zpt.testSPieceRotate(true);
		zpt.testMoveBy();
		zpt.testMoveByWithPile();
	}
	
	public void testConstructorPoint(){
		SPiece zp = new SPiece(new Point());
		System.out.println("Coordonnees SPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXY(){
		SPiece zp = new SPiece(2,3);
		System.out.println("Coordonnees SPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYColour(){
		SPiece zp = new SPiece(1,3,Color.BLACK);
		System.out.println("Coordonnees SPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYPoint(){
		SPiece zp = new SPiece(new Point(5,4),Color.BLACK);
		System.out.println("Coordonnees SPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testSPieceAccessors(){
		SPiece zp = new SPiece(0,0);
		System.out.println("Elements : "+zp.getElements());
		System.out.println();
	}
	
	public void testSPieceAscii(){
		SPiece zp = new SPiece(0,0);	
		System.out.println(zp.getAsciiArt());
	}
	
	public void testSPieceRotate(boolean bool){
		SPiece zp = new SPiece(2, 3);	
		
		zp.setGameBoard(new GameBoard());
		zp.getGameBoard().setCurrentPiece(zp);
		zp.getGameBoard().setPile(new Pile(zp.getGameBoard(),10,4));
		
		System.out.println("Test Rotation");
		System.out.println(zp.getGameBoard().getAsciiArt());
		
		try {
			zp.rotatePiece(bool);
		} catch (BloxException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(zp.getGameBoard().getAsciiArt());
		System.out.println();
	}
	
	public void testMoveBy(){
		SPiece zp = new SPiece(2, 3); //Test non valide en (0 ; 0)
		
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
		SPiece zp = new SPiece(2, 3); //Test non valide en (0 ; 0)
		
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
