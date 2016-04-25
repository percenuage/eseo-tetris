package fr.eseo.blox.view;

import java.awt.Graphics2D;
import fr.eseo.blox.model.Pile;

public class ViewPile {
	
	private GameBoardPanel gbp;
	private Pile pile;

	public ViewPile(GameBoardPanel gbp) {
		setGameBoardPanel(gbp);
	}
	
	public void display(Graphics2D g2D) {
		if (gbp != null && gbp.getGameBoard() != null && pile != null) {
			for (int i = 0; i < gbp.getGameBoard().getHeight(); i++) {
				for (int j = 0; j < gbp.getGameBoard().getWidth(); j++) {
					if (pile.getElements()[j][i] != null) {
						g2D.setPaint(pile.getElements()[j][i].getColour().darker());
						g2D.fill3DRect(j*gbp.getElementSize(), i*gbp.getElementSize(), 
									gbp.getElementSize(), gbp.getElementSize(), true);
					}
				}
			}
		}
	}
	
	public GameBoardPanel getGameBoardPanel() {
		return gbp;
	}

	public void setGameBoardPanel(GameBoardPanel gbp) {	
		if (gbp != null && gbp.getGameBoard() != null) {	
			gbp.setViewPile(this);
			this.setPile(gbp.getGameBoard().getPile());
		}
		this.gbp = gbp;	
	}
	
	public Pile getPile() {
		return pile;
	}

	public void setPile(Pile pile) {
		this.pile = pile;
	}

}
