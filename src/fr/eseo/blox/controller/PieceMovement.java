package fr.eseo.blox.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.view.GameBoardPanel;

public class PieceMovement implements MouseMotionListener, MouseWheelListener {
	
	private GameBoard gameBoard;
	private GameBoardPanel gameBoardPanel;

	public PieceMovement(GameBoardPanel gameBoardPanel) {
		setGameBoardPanel(gameBoardPanel);
		setGameBoard(gameBoardPanel.getGameBoard());
	}
	
	public void mouseMoved(MouseEvent event) {
		int x0 = gameBoard.getCurrentPiece().getElements().get(0).getX();
		try {
			if (event.getX() < x0*gameBoardPanel.getElementSize()) {
				gameBoard.getCurrentPiece().moveBy(-1, 0);
			}
			if (event.getX() >= (x0 + 1)*gameBoardPanel.getElementSize()) {
				gameBoard.getCurrentPiece().moveBy(1, 0);
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (BloxException e) {
			System.err.println(e.getMessage());
		} 
		gameBoardPanel.repaint();
	}
	
	public void mouseDragged(MouseEvent event) {}
	
	public void mouseWheelMoved(MouseWheelEvent event) {
		if (event.getWheelRotation() > 0) {
			gameBoard.gravity();
		}
		gameBoardPanel.repaint();
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public GameBoardPanel getGameBoardPanel() {
		return gameBoardPanel;
	}

	public void setGameBoardPanel(GameBoardPanel gameBoardPanel) {
		this.gameBoardPanel = gameBoardPanel;
	}

	
}
