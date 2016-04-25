package fr.eseo.blox.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

@SuppressWarnings("serial")
public class BloxFrame extends JFrame{

	public static final String DEFAULT_TITLE = "TETRIS";
	private GameBoardPanel gBPanel;
	private String title;
	private LoserPanel loserPanel;
	private InfoScreenPanel inf;

//############__CONSTRUCTORS__################//

	public BloxFrame(){
		this(DEFAULT_TITLE, new GameBoardPanel());

	}

	public BloxFrame(GameBoardPanel gbp){
		this(DEFAULT_TITLE, gbp);

	}

	public BloxFrame(String title, GameBoardPanel gbp){
		super(title);
		this.setLayout(new BorderLayout());//creates a layout in order to manage the panels
		this.setGameBoardPanel(gbp);			//such as the gameBoardPanel or the infoScreenPanel
		this.getContentPane().add(gBPanel, BorderLayout.WEST);
		this.inf = new InfoScreenPanel(this);
		this.getContentPane().add(inf, BorderLayout.EAST);
		
		Image img = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/infoscreen.png")).getImage();//loads an image
		this.inf.setBackGround(img);//input a background image on the infoScreenPanel
		this.inf.setVisible(true);	//this image will be dealt with in the panel's paintComponent method
		Image gameboard = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/space.png")).getImage();
		this.getGameBoardPanel().setBackGround(gameboard);//input a background image on the gameBoardPanel
		this.getGameBoardPanel().setVisible(true);
		this.loserPanel = new LoserPanel(new ImageIcon(this.getClass().getClassLoader().getResource("ressources/GameOver.jpg")).getImage());//creates a new loserPanel with a loaded image
		this.getContentPane().add(this.loserPanel);
		this.loserPanel.setVisible(false);
		this.gBPanel.setBloxFrame(this);
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


//############__METHODS__################//

	public void loserPanel(){//reference to the LoserPanel class
													//this method creates the buttons on the game over screen
		this.getGameBoardPanel().setVisible(false);
		this.loserPanel.setLayout(new BorderLayout());
		JButton backToMenu = new JButton("Back to Menu");
		this.loserPanel.add(backToMenu, BorderLayout.SOUTH);
    		backToMenu.addActionListener(new ActionListener(){//Defining the click action on the button
      		public void actionPerformed(ActionEvent event){
				dispose();
      		}
    		});
		this.setTitle("You lose!");
		this.loserPanel.setBloxFrame(this);
		this.loserPanel.setVisible(true);

	}


//############__ACCESSORS & SETRS__################//

	public GameBoardPanel getGameBoardPanel(){

		return this.gBPanel;

	}

	public void setGameBoardPanel(GameBoardPanel gbp){

		this.gBPanel = gbp;
		this.setSize((int)this.gBPanel.getPreferredSize().getWidth(), (int)this.gBPanel.getPreferredSize().getHeight());
		this.getGameBoardPanel().setBloxFrame(this);

	}

	public InfoScreenPanel getInfoScreenPanel(){

		return this.inf;

	}


}
