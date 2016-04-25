package fr.eseo.blox.tests.view;

import javax.swing.SwingUtilities;
import fr.eseo.blox.model.GameBoard;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.GameBoardPanel;

public class BloxFrameTest {

	public static final void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new BloxFrameTest();
				
			}
		});
	}
	
	public BloxFrameTest () {
		testBloxFrameDefault();
		testBloxFrameElSize();
		testBloxFrameGB();
		testBloxFrameElSizeGB();
	}
	
	public void testBloxFrameDefault() {
		new BloxFrame();
	}
	
	public void testBloxFrameElSize() {
		new BloxFrame("Test Element Size = 50", new GameBoardPanel(50));
	}
	
	public void testBloxFrameGB() {
		new BloxFrame("Test GameBoard (15;30)", new GameBoardPanel(new GameBoard(15, 30)));
	}
	
	public void testBloxFrameElSizeGB() {
		new BloxFrame("Test ElementSize and GameBoard", new GameBoardPanel(new GameBoard(30, 20), 10));
	}
	
}
