package fr.eseo.blox.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.view.GameBoardPanel;

public class PieceRotation extends MouseAdapter{
	
	private GameBoard gameBoard;
	private GameBoardPanel gameBoardPanel;
	
	public PieceRotation(GameBoardPanel gameBoardPanel) {
		setGameBoardPanel(gameBoardPanel);
		setGameBoard(gameBoardPanel.getGameBoard());
	}
	
	public void mouseClicked(MouseEvent event) {
		try {
			if (SwingUtilities.isLeftMouseButton(event)) {
				gameBoard.getCurrentPiece().rotatePiece(false);
			}
			if (SwingUtilities.isRightMouseButton(event)) {
				gameBoard.getCurrentPiece().rotatePiece(true);
			}
		} catch (BloxException e) {
			System.err.println(e.getMessage());
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
