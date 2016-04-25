package fr.eseo.blox.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Image;

import fr.eseo.blox.controller.GravityTimer;
import fr.eseo.blox.controller.PieceMovement;
import fr.eseo.blox.controller.PieceRotation;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.model.Piece;
import fr.eseo.blox.model.ZPiece;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel {

	public static final int DEFAULT_ELEMENT_SIZE = 30;
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 20;
	public static final int DEFAULT_TIMER_INTERVAL = 650;
	
	private int elementSize;
	private GameBoard gameBoard;
	private BloxFrame bloxFrame;
	private ViewPile viewPile;
	private ViewPiece viewPiece;
	
	private Image backGround;
	
	private GravityTimer gravityTimer;
	private int timerInterval;
	
	public GameBoardPanel() {
		this(DEFAULT_ELEMENT_SIZE);
	}

	public GameBoardPanel(GameBoard gb) {
		this(gb, DEFAULT_ELEMENT_SIZE);
	}

	public GameBoardPanel(int squareSize) {
		this(new GameBoard(DEFAULT_WIDTH, DEFAULT_HEIGHT), squareSize);
	}
	
	public GameBoardPanel(GameBoard gb, int squareSize) {
		this(gb, squareSize, DEFAULT_TIMER_INTERVAL);
	}
	
	public GameBoardPanel(GameBoard gb, int squareSize, int timerInterval) { /****/
		setGameBoard(gb);
		setElementSize(squareSize);
		setPreferredSize(new Dimension(gameBoard.getWidth()*elementSize, gameBoard.getHeight()*elementSize));
		
		if (gameBoard != null && gameBoard.getNextPiece() == null) {
			gameBoard.setNextPiece(PieceFactory.newPiece(gameBoard));
		}
		
		setViewPile(new ViewPile(this));
		setViewPiece(new ViewPiece(this));
		
		this.addMouseMotionListener(new PieceMovement(this));
		this.addMouseWheelListener(new PieceMovement(this));
		this.addMouseListener(new PieceRotation(this));
		
		setGravityTimer(new GravityTimer(this, timerInterval));
		this.timerInterval = timerInterval;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D)g.create();	
		for (int i = 0; i < gameBoard.getHeight(); i++) {
			for (int j = 0; j < gameBoard.getWidth(); j++) {
				g2.setPaint(Color.BLACK);
				g2.drawRect(j*elementSize, i*elementSize, elementSize, elementSize);
			}
		}
		g2.drawImage(backGround,0,0,null);//draws the background image
		viewPiece.display(g2);
		viewPile.display(g2);
		if(this.getGameBoard().getNextPiece()!=null){//creates a copy of the NextPiece to display on the infoScreenPanel
			Piece showNext = new ZPiece(0,0);
			for(int i=0; i<4; i++){
				showNext.getElements().get(i).setX(this.getGameBoard().getNextPiece().getElements().get(i).getX());
				showNext.getElements().get(i).setY(this.getGameBoard().getNextPiece().getElements().get(i).getY());
				showNext.getElements().get(i).setColour(this.getGameBoard().getNextPiece().getElements().get(i).getColour());
				showNext.getElements().get(i).setY(showNext.getElements().get(i).getY()+10);
			}
			this.bloxFrame.getInfoScreenPanel().setPiece(showNext);
		}
		g2.dispose();
	}

	public int getElementSize() {
		return elementSize;
	}

	public void setElementSize(int elSize) {
		this.elementSize = elSize;
		setPreferredSize(new Dimension(gameBoard.getWidth()*elementSize, gameBoard.getHeight()*elementSize));
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gb) {
		this.gameBoard = gb;
		setPreferredSize(new Dimension(gameBoard.getWidth()*elementSize, gameBoard.getHeight()*elementSize));
	}

	public BloxFrame getBloxFrame() {
		return bloxFrame;
	}

	public void setBloxFrame(BloxFrame frame) {
		this.bloxFrame = frame;
	}

	public ViewPile getViewPile() {
		return viewPile;
	}
	
	public void setViewPile(ViewPile viewPile) {
		this.viewPile = viewPile;
	}

	public ViewPiece getViewPiece() {
		return viewPiece;
	}

	public void setViewPiece(ViewPiece viewPiece) {
		this.viewPiece = viewPiece;
	}

	public int getTimerInterval() {
		return timerInterval;
	}

	public void setTimerInterval(int timerInterval) {
		this.timerInterval = timerInterval;
		this.getGravityTimer().setTimerInterval(timerInterval);
	}

	public GravityTimer getGravityTimer() {
		return gravityTimer;
	}

	public void setGravityTimer(GravityTimer gravityTimer) {
		this.gravityTimer = gravityTimer;
	}
	
	public void setBackGround(Image bgd){

		this.backGround = bgd;

	}

}
