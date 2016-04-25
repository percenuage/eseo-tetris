//Packages
package fr.eseo.blox.model;

//Imports
import java.awt.Color;
import java.awt.Point;

//Classes
public class Element{

	//Attributs
	public static final Color DEFAULT_ELEMENT_COLOUR = Color.LIGHT_GRAY; //"." parce que "static"
	private Point coordinate;
	private Color colour;

	//Constructeurs
	public Element(Point coordinate) {
		this(coordinate,Element.DEFAULT_ELEMENT_COLOUR);
	}
	
	public Element(int x, int y) {
		this(x,y,Element.DEFAULT_ELEMENT_COLOUR);
	}
	
	public Element(Point coordinate, Color colour) {
		this.coordinate = new Point(coordinate);
		this.colour = colour;
	}
	
	public Element(int x, int y, Color colour) {
		this.coordinate = new Point(x,y);
		this.colour = colour;
	}

	//Accesseurs
	public Point getCoordinate() {
		return this.coordinate;
	}
	
	public int getX() {
		return this.coordinate.x;
	}
	
	public int getY() {
		return this.coordinate.y;
	}
	
	public Color getColour() {
		return this.colour;
	}

	//Mutateurs
	public void setCoordinate(Point point){
		this.coordinate.setLocation(point);
	}
	
	public void setCoordinate(int x, int y){
		this.coordinate.setLocation(x,y);
	}
	
	public void setX(int x){
		this.coordinate.x = x;
	}
	
	public void setY(int y){
		this.coordinate.y = y;
	}
	
	public void setColour(Color colour){
		this.colour = colour;
	}

	//Méthodes
	public String toString() {
		return "("+this.getX()+","+this.getY()+")";
	}
	
	public void moveBy(int dx, int dy) throws IllegalArgumentException{
		if(dy <= -1){
			throw(new IllegalArgumentException("INCORRECT UPWARDS MOVEMENT"));
		}
		else if (dx > 1 || dx < -1 || dy > 1) {
			throw(new IllegalArgumentException("TOO MANY INCORRECT MOVEMENT"));
		}
		else {
			this.setCoordinate(this.getX() + dx, this.getY() + dy);
		}	
	}

}
