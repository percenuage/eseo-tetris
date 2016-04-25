package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.IPiece;
import fr.eseo.blox.model.Pile;

public class IPieceTest {
	
	public static void main(String[] args) {
		IPieceTest zpt= new IPieceTest();
		//Test constructeurs
		zpt.testConstructorPoint();
		zpt.testConstructorXY();
		zpt.testConstructorXYColour();
		zpt.testConstructorXYPoint();
		//Test accesseurs
		zpt.testIPieceAccessors();
		//Test methodes
		zpt.testIPieceAscii();
		zpt.testIPieceRotate(true);
		zpt.testMoveBy();
		zpt.testMoveByWithPile();
	}
	
	public void testConstructorPoint(){
		IPiece zp = new IPiece(new Point());
		System.out.println("Coordonnees IPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXY(){
		IPiece zp = new IPiece(2,3);
		System.out.println("Coordonnees IPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYColour(){
		IPiece zp = new IPiece(1,3,Color.BLACK);
		System.out.println("Coordonnees IPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testConstructorXYPoint(){
		IPiece zp = new IPiece(new Point(5,4),Color.BLACK);
		System.out.println("Coordonnees IPiece : "+zp.toString());
		System.out.println();
	}
	
	public void testIPieceAccessors(){
		IPiece zp = new IPiece(0,0);
		System.out.println("Elements : "+zp.getElements());
		System.out.println();
	}
	
	public void testIPieceAscii(){
		IPiece zp = new IPiece(0,0);	
		System.out.println(zp.getAsciiArt());
	}
	
	public void testIPieceRotate(boolean bool){
		IPiece zp = new IPiece(2, 3);
		
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
		IPiece zp = new IPiece(2, 3); //Test non valide en (0 ; 0)
		
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
		IPiece zp = new IPiece(2, 3); //Test non valide en (0 ; 0)
		
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
