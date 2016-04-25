
package fr.eseo.blox;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.view.GameBoardPanel;


@SuppressWarnings("serial")
public final class MenuTetris extends javax.swing.JFrame{

    private GameBoardPanel gameBoardPanel;
    private Pile pile;
    private Thread sound;
   
    public MenuTetris() {
        this(new GameBoardPanel());
    }
    
    public MenuTetris(GameBoardPanel gbp) {
        gameBoardPanel = gbp;
        gameBoardPanel.getGravityTimer().getTimer().stop();
        sound = new Thread(new Sound(this.getClass().getClassLoader().getResource("ressources/Tetris - Basshunter remix.wav")));
        
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jRadioButtonMenuItem6 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem10 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem11 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TETRIS");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setName(""); // NOI18N

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("By Axel Gendillard & Nicolas Launay");

        jLabel2.setBackground(new java.awt.Color(255, 51, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Welcome on Tetris Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        jMenu2.setText("Edit level");

        jMenu3.setText("Speed");

        jRadioButtonMenuItem1.setText("Very Slow");
        jRadioButtonMenuItem1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonMenuItem1StateChanged(evt);
            }
        });
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setText("Slow");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setText("Normal");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem4.setText("Fast");
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem4);

        jRadioButtonMenuItem5.setText("Very Fast");
        jRadioButtonMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem5);

        jMenu2.add(jMenu3);

        jMenu5.setText("Pile");

        jRadioButtonMenuItem6.setText("0");
        jRadioButtonMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem6);

        jRadioButtonMenuItem7.setText("10");
        jRadioButtonMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem7);

        jRadioButtonMenuItem8.setText("25");
        jRadioButtonMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem8);

        jRadioButtonMenuItem9.setText("50");
        jRadioButtonMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem9);

        jRadioButtonMenuItem10.setText("100");
        jRadioButtonMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem10);

        jRadioButtonMenuItem11.setText("ESEO");
        jRadioButtonMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem11);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
            if (gameBoardPanel.getWidth() != 26) {
                gameBoardPanel = null;
            }        
        }
        if(gameBoardPanel == null) {
            gameBoardPanel = new GameBoardPanel();
        }
        if (gameBoardPanel.getGameBoard().getPile() == null) {
            new Pile(gameBoardPanel.getGameBoard(), 0);
        }
        if (pile != null) {
            gameBoardPanel.getGameBoard().setPile(pile);
        }
        if (gameBoardPanel.getGameBoard().getCurrentPiece() == null) {
            gameBoardPanel.getGameBoard().setCurrentPiece(PieceFactory.newPiece(gameBoardPanel.getGameBoard()));
        }
        if("Restart".equals(jButton2.getText())) {
            jButton2.setText("Pause");
        }
        if ("Play".equals(jButton1.getText())) {
            jButton1.setText("New");
            sound.start();
        }
        
        gameBoardPanel.getGravityTimer().getTimer().start();
        try {
            new BloxGame(gameBoardPanel);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonMenuItem1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem1StateChanged

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        //jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        gameBoardPanel.setTimerInterval(900);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ("Pause".equals(jButton2.getText())) {
            jButton2.setText("Restart");
            gameBoardPanel.getGravityTimer().getTimer().stop();
            //sound.stop();
        } else {
            jButton2.setText("Pause");
            gameBoardPanel.getGravityTimer().getTimer().start();
            //sound.start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        jRadioButtonMenuItem1.setSelected(false);
        //jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        gameBoardPanel.setTimerInterval(700);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        //jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        gameBoardPanel.setTimerInterval(500);
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        //jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        gameBoardPanel.setTimerInterval(300);
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jRadioButtonMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem5ActionPerformed
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        //jRadioButtonMenuItem5.setSelected(false);
        gameBoardPanel.setTimerInterval(100);
    }//GEN-LAST:event_jRadioButtonMenuItem5ActionPerformed

    private void jRadioButtonMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem6ActionPerformed
        //jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        pile = new Pile(gameBoardPanel.getGameBoard(), 0);
    }//GEN-LAST:event_jRadioButtonMenuItem6ActionPerformed

    private void jRadioButtonMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem7ActionPerformed
        jRadioButtonMenuItem6.setSelected(false);
        //jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false); 
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        pile = new Pile(gameBoardPanel.getGameBoard(), 10);
    }//GEN-LAST:event_jRadioButtonMenuItem7ActionPerformed

    private void jRadioButtonMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem8ActionPerformed
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        //jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false); 
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        pile = new Pile(gameBoardPanel.getGameBoard(), 25);
    }//GEN-LAST:event_jRadioButtonMenuItem8ActionPerformed

    private void jRadioButtonMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem9ActionPerformed
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        //jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        pile = new Pile(gameBoardPanel.getGameBoard(), 50);
    }//GEN-LAST:event_jRadioButtonMenuItem9ActionPerformed

    private void jRadioButtonMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem10ActionPerformed
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        //jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        pile = new Pile(gameBoardPanel.getGameBoard(), 100);
    }//GEN-LAST:event_jRadioButtonMenuItem10ActionPerformed

    private void jRadioButtonMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem11ActionPerformed
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        //jRadioButtonMenuItem11.setSelected(false);
        
        /*********************************************************************/
        if (gameBoardPanel.getBloxFrame() != null) {
            gameBoardPanel.getBloxFrame().dispose();
            gameBoardPanel.getGravityTimer().getTimer().stop();
        }
        //gameBoardPanel = new GameBoardPanel(new GameBoard(26, 15));
        try {
            //new ESEO(gameBoardPanel.getGameBoard(), 2, 12);
            new ESEO(gameBoardPanel.getGameBoard(), 0, 2);
        } catch (BloxException e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_jRadioButtonMenuItem11ActionPerformed

    /**
     * @param args the command line arguments
     */
    
 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuTetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            //SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuTetris().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem10;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem11;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem6;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the gameBoardPanel
     */
    public GameBoardPanel getGameBoardPanel() {
        return gameBoardPanel;
    }

    /**
     * @param gameBoardPanel the gameBoardPanel to set
     */
    public void setGameBoardPanel(GameBoardPanel gameBoardPanel) {
        this.gameBoardPanel = gameBoardPanel;
    }
}
