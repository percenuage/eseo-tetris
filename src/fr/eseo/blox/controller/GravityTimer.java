package fr.eseo.blox.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.view.GameBoardPanel;
import javax.swing.Timer;

public class GravityTimer implements ActionListener {
	
	private GameBoard gameBoard;
	private GameBoardPanel gameBoardPanel;
	private Timer timer;
	private int timerInterval;
	
	public GravityTimer(GameBoardPanel gameBoardPanel, int timerInterval) {
		setGameBoardPanel(gameBoardPanel);
		setGameBoard(gameBoardPanel.getGameBoard());
		setTimer(new Timer(timerInterval, this));
		this.timerInterval = timerInterval;
		this.timer.start();
	}
	
	public void actionPerformed(ActionEvent action){
		try{
			if (this.gameBoardPanel.getGameBoard().gravity()) {
				//this.gameBoardPanel.getBloxFrame().getInfoScreenPanel().repaint();
			}		
		}catch(ArrayIndexOutOfBoundsException out){
			this.timer.stop();
			this.gameBoardPanel.getBloxFrame().loserPanel();
		}
		this.gameBoardPanel.getBloxFrame().getInfoScreenPanel().repaint();
		this.gameBoardPanel.repaint();

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
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getTimerInterval() {
		return timerInterval;
	}

	public void setTimerInterval(int timerInterval) {
		this.timerInterval = timerInterval;
		getTimer().setDelay(timerInterval);
	}



	

}
