package fr.eseo.blox.view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;




@SuppressWarnings("serial")
public class LoserPanel extends JPanel{

	public static final int DEFAULT_ELEMENT_SIZE = 10;
	public static final int DEFAULT_WIDTH = 20;
	public static final int DEFAULT_HEIGHT = 25;
	public int elementSize;
	private BloxFrame bloxFrame;
	private Image backGround;


//############__CONSTRUCTORS__################//


	public LoserPanel(Image img){

		this.setElementSize(DEFAULT_ELEMENT_SIZE);
		this.setPreferredSize(new Dimension(20*elementSize, 20*elementSize));	
		this.backGround = img;

	}


//############__METHODS__################//

   public void paintComponent(Graphics g) {
       g.drawImage(backGround,0,0,null);//paints an image loaded from the constructor on the panel
               
   }

//############__ACCESSORS & SETRS__################//


	public BloxFrame getBloxFrame(){

		return this.bloxFrame;

	}

	public void setBloxFrame(BloxFrame frame){

		this.bloxFrame = frame;

	}

	public int getElementSize(){

		return this.elementSize;

	}

	public void setElementSize(int elSize){

		this.elementSize = elSize;
		this.setPreferredSize(new Dimension(20*elementSize, 20*elementSize));	

	}

}
