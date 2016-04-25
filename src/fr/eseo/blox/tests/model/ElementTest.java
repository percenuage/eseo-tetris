//Packages
package fr.eseo.blox.tests.model;

//Imports
import fr.eseo.blox.model.Element;

import java.awt.Color;
import java.awt.Point;

//Classe
public class ElementTest {

	public static void main(String[] args) {
		ElementTest element = new ElementTest();
		//Test constructeurs
		element.testConstructorPoint();
		element.testConstructorXY();
		element.testConstructorPointColour();
		element.testConstructorXYColour();
		//Test accesseurs
		element.testColourAccessors();
		element.testCoordAccessors();
		element.testXYAccessors();
		//Test methodes
		element.testMoveBy();
	}
	
	public void testConstructorPoint(){
		Element el = new Element(new Point(5,5));
		System.out.println("Coordonnee Element : "+el.toString());
		System.out.println("Colour : "+el.getColour());
		System.out.println();	
	}
	
	public void testConstructorXY(){
		Element el = new Element(1,0);
		System.out.println("Coordonnee Element : "+el.toString());
		System.out.println("Colour : "+el.getColour());
		System.out.println();	
	}
	
	public void testConstructorPointColour(){
		Element el = new Element(new Point(2,-2),Color.BLUE);
		System.out.println("Coordonnee Element : "+el.toString());
		System.out.println("Colour : "+el.getColour());
		System.out.println();	
	}
	
	public void testConstructorXYColour(){
		Element el = new Element(new Point(-4,0),Color.MAGENTA);
		System.out.println("Coordonnee Element : "+el.toString());
		System.out.println("Colour : "+el.getColour());
		System.out.println();	
	}
	
	public void testCoordAccessors(){
		Element el = new Element(1,0);
		el.setCoordinate(new Point());
		System.out.println("GetterCoordPoint : "+el.getCoordinate());
		el.setCoordinate(-1, 0);
		System.out.println("GetterCoordXY : "+el.getCoordinate());
		System.out.println();
	}
	
	public void testColourAccessors(){
		Element el = new Element(0, 0);
		el.setColour(Color.CYAN);
		System.out.println("GetterColour : "+el.getColour());
		System.out.println();
	}
	
	public void testXYAccessors(){
		Element el = new Element(0, 0);
		el.setX(10);
		el.setY(-10);
		System.out.println("GetterXY : "+el.getX()+" ; "+el.getY());
		System.out.println();
	}
	
	public void testMoveBy(){
		Element el = new Element(0, 0);
		try{
			el.moveBy(1, 0);
			el.moveBy(0, -2);
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
	}
	
}
