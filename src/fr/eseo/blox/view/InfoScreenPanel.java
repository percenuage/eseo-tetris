package fr.eseo.blox.view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import fr.eseo.blox.model.Piece;
import fr.eseo.blox.model.GameBoard;
import java.awt.Image;

@SuppressWarnings("serial")
public class InfoScreenPanel extends JPanel{

	public static final int DEFAULT_ELEMENT_SIZE = 30;
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 20;
	public int elementSize;
	private Piece piece;
	private GameBoard gbp;
	private Image backGround;
	private BloxFrame bloxFrame;


//############__CONSTRUCTORS__################//


	public InfoScreenPanel(BloxFrame bloxFrame){

		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setElementSize(DEFAULT_ELEMENT_SIZE);
		this.bloxFrame = bloxFrame;
	
	}


//############__METHODS__################//

	public void paintComponent(Graphics g){
	  if(this.piece != null){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g.create();
			g2.setPaint(Color.BLACK);
			g2.drawImage(backGround,0,0,null);//paints an image on the panel
				for(int i=0; i<4; i++){//paints the gameBoard's NextPiece on the panel
					g2.setPaint(this.piece.getElements().get(i).getColour());
					g2.fill3DRect(this.piece.getElements().get(i).getX()*this.getElementSize(),this.piece.getElements().get(i).getY()*this.getElementSize(),this.getElementSize(),this.getElementSize(),true);
				}
			g2.dispose();
		}
	}


//############__ACCESSORS & SETRS__################//


	public GameBoard getGameBoard(){

		return this.gbp;

	}

	public int getElementSize(){

		return this.elementSize;

	}
	public void setElementSize(int elSize){

		this.elementSize = elSize;
		this.setPreferredSize(new Dimension(10*elementSize, 20*elementSize));	

	}
	
		public void setBloxFrame(BloxFrame frame){

		this.bloxFrame = frame;

	}
	
		public void setBackGround(Image bgd){

		this.backGround = bgd;

	}
	
		public void setPiece(Piece piece){
		
		this.piece = piece;

	}


}
