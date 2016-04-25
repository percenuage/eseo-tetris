package fr.eseo.blox.model;

import java.awt.Color;
import java.awt.Point;

public class JPiece extends Piece{
	
	private static final Point[] RELATIVE_ELEMENTS_COORDS = {new Point(),new Point(0,-2),new Point(0,-1),new Point(-1,0)};

	public JPiece(Point coordinate){	
	
		super(coordinate);
	}
	public JPiece(int x, int y){	
	
		super(new Point(x,y));
	}
	public JPiece(Point coordinate, Color colour){	
	
		super(coordinate, colour);
	}
	public JPiece(int x, int y, Color colour){	
	
		super(new Point(x,y), colour);
	}
	
	protected void setElements(Point coordinate, Color pieceColour){

		for(int i=0 ; i<RELATIVE_ELEMENTS_COORDS.length ; i++){
			this.getElements().add(new Element(RELATIVE_ELEMENTS_COORDS[i].x + coordinate.x , RELATIVE_ELEMENTS_COORDS[i].y + coordinate.y , pieceColour));
		}
	}
}
