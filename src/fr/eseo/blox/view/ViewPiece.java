package fr.eseo.blox.view;

import java.awt.Graphics2D;
import fr.eseo.blox.model.Piece;

public class ViewPiece {
	
	private GameBoardPanel gbp;
	private Piece piece;
	
	public ViewPiece(GameBoardPanel gbp) {
		setGameBoardPanel(gbp);
	}
	
	public void display(Graphics2D g2D) {
		setGameBoardPanel(gbp);
		if (piece != null) {
			for (int i = 0; i < 4; i++) {
				int x = piece.getElements().get(i).getX();
				int y = piece.getElements().get(i).getY();
				if (y >= 0) {
					g2D.setPaint(piece.getElements().get(i).getColour());
					g2D.fill3DRect(x*gbp.getElementSize(), y*gbp.getElementSize(),
								gbp.getElementSize(), gbp.getElementSize(), true);
				}
			}
		}		
	}

	public GameBoardPanel getGameBoardPanel() {
		return gbp;
	}

	public void setGameBoardPanel(GameBoardPanel gbp) {
		if (gbp != null && gbp.getGameBoard() != null) {
			gbp.setViewPiece(this);
			this.setPiece(gbp.getGameBoard().getCurrentPiece());
		}
		this.gbp = gbp;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
