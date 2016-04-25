package fr.eseo.blox;

import fr.eseo.blox.model.*;
import fr.eseo.blox.view.*;


public class BloxGame{
      
	public BloxGame(GameBoardPanel gbp) throws BloxException {
                
		new ViewPiece(gbp);
		new ViewPile(gbp);
		new BloxFrame(gbp);
	}
        
        public BloxGame() throws BloxException {
            this(new GameBoardPanel());
        }
	
	/**
	 * music => ok
	 * pause du jeu => ok
	 * Pile ESEO => ok
     * level (choix pile, eseo, vitesse) => ok
     * menu graphique => ok
	 
	 * menu graphique
	 * level (choix pile, eseo, vitesse)
	 * Affichage(nextPiece, level, point, gameOver(nico))
		 
	 * sauvegarde / chargement
	 * scores (ecrire / lire dans un fichier)
	 * Nom joueur
	 * controler clavier 
	 * multiplayers
	 * timer
	 * ia
	 * online - network
	 **/

}
