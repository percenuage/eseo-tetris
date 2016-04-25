package fr.eseo.blox.model;

import java.awt.Color;
import java.util.Random;

public class Pile {

	private GameBoard gameBoard;
	private Element[][] elements;

	public Pile(GameBoard gameBoard) {
		this(gameBoard,0,0);
	}

	public Pile(GameBoard gameBoard, int nbElements) {
		this(gameBoard,nbElements,0);
	}

	public Pile(GameBoard gameBoard, int nbElements, int nbRows) {
		gameBoard.setPile(this);
		this.gameBoard = gameBoard;
		elements = new Element[gameBoard.getWidth()][gameBoard.getHeight()];
		
		if (nbElements < 0) {
			nbElements = 0;	
		}
		
		if (nbRows < 0) {
			nbRows = 0;
		}
		
		if (nbRows > gameBoard.getHeight()) {
			nbRows = gameBoard.getWidth();
		}
		
		if (nbRows == 0) {
			nbRows = nbElements/gameBoard.getWidth() + 1; 
			if (nbRows > gameBoard.getHeight()) {
				nbRows = gameBoard.getHeight();
			}
		}
		
		if (nbElements > nbRows*gameBoard.getWidth()) {
			nbElements = nbRows*gameBoard.getWidth();
		}
		
		Random rand = new Random();	
		
		while (nbElements != 0) {
			int rows = gameBoard.getHeight() - rand.nextInt(nbRows) - 1;
			int column = rand.nextInt(gameBoard.getWidth());
			
			if(elements[column][rows] == null){ /* verification si la case est vide */
				elements[column][rows] = new Element(column, rows, new Color(rand.nextInt()));
				nbElements--;
			}
		}	
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		if(gameBoard != null){
			gameBoard.setPile(this); 
		}
		//ICI faire une copie de la pile en adaptant
		this.gameBoard = gameBoard;
	}

	public Element[][] getElements() {
		return elements;
	}
	
	public String getAsciiArt() {	// M�thode � appeler pour afficher la pile simplement
		if (gameBoard != null) {
			return gameBoard.getAsciiArt();
		} else {
			return null;
		}
	}
	
	public void addElements(Piece piece) {
		for (int i = 0; i < 4; i++) {
			int x = piece.getElements().get(i).getX();
			int y = piece.getElements().get(i).getY();
			elements[x][y] = piece.getElements().get(i);
		}
	}
	
	public int checkFullRows() {
		int nbRowsSupp = 0; //Nombre lignes supprim�
		
		/* Check les rang�es pleines */
		for (int i = gameBoard.getHeight() - 1; i >= 0 ; i--) {
			int nbElements = 0;
			for (int j = 0; j < gameBoard.getWidth(); j++) {
				if (elements[j][i] != null) {
					nbElements++;
				}
			}
			
			/* Les �lements de la pile chutent et suppression de la ligne i */
			if (nbElements == gameBoard.getWidth()) {
				for (int k = i; k >= 0 ; k--) { 
					for (int j = 0; j < gameBoard.getWidth(); j++) {
						if (k != 0) {
							elements[j][k] = elements[j][k-1]; 
						} else {
							elements[j][k] = null; //Ligne du haut supprim�e
						}
					}
				}
				nbRowsSupp++;
				i++; //Apr�s la chute, il doit v�rifier la ligne actuelle
			}
		}	
		return nbRowsSupp;
	}	
}
