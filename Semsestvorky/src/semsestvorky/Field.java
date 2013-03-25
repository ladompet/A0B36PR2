/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static semsestvorky.MainMenu.x;

/**
 *
 * @author Piotr04_SVK
 */
public class Field extends JPanel implements ItemListener {

    boolean effects = true;
    int farba;
    int endgame = 0;
    int numberTurn;     // coneect6 vs tic tac toe turn
    int firstscore = 0;
    int secondscore = 0;
    boolean iconset1 = false;
    boolean iconset2 = false;
    boolean prvy = true;
    int TTT1;   // tic tac toe 1
    int TTT2;   // tic tac toe 2
    int TTT3;   // tic tac toe 3
    int width;
    int height;
    int ii = 0; // turns connect6
    int t = 1;  // turns tic tac toe
    boolean turn = true;
    Win win;
    JButton[][] field;
    ImageIcon[] icColor = new ImageIcon[10];
    ImageIcon[] icPlayer = new ImageIcon[2];
    JCheckBox soundfx = new JCheckBox("Sound FX",true);
    JButton playerpics = new JButton();
    

    Field(int n, int m, boolean hra, int d) {
        width = n;
        height = m;
        if (hra == true) {
            numberTurn = 2;
            TTT1 = 6;
            TTT2 = 4;
            TTT3 = 5;
        } else if (hra == false) {
            prvy = false;
            TTT1 = 5;
            TTT2 = 3;
            TTT3 = 1;
            numberTurn = 1;
        }

        color(d);
        JLabel hrac = new JLabel("TURN :");
        Panel p = new Panel();
        p.setBounds(0, x * m, x * n * 2, 50);

        p.add(hrac);
        hrac.setBounds(x * n - 75, x * m, 75, 25);
        hrac.setFont(new Font("Arial", Font.BOLD, 12));
        hrac.setForeground(Color.BLACK);
        this.add(hrac);

        p.add(playerpics);
        playerpics.setIcon(icPlayer[1]);
        playerpics.setBounds((x * n) - 30, x * m, 26, 26);
        this.add(playerpics);

        p.add(soundfx);
        soundfx.setBackground(Color.GRAY);
        soundfx.setForeground(Color.BLACK);
        soundfx.setBounds(7, x * m + 2, 100, 20);
        soundfx.setFont(new Font("Arial", Font.ITALIC, 12));
        this.add(soundfx);
        

        this.add(p);
        this.setBackground(Color.GRAY);
        this.setLayout(null);

        field = new JButton[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = new JButton(icColor[9]);
                field[i][j].addMouseListener(new MouseL(i, j));
                int x = 35;
                field[i][j].setBounds(x * i, x * j, x, x);
                this.add(field[i][j]);
            }
        }
                soundfx.addItemListener(this);
    }
    
        
    @Override
        public void itemStateChanged(ItemEvent e) {
           if (soundfx.isSelected()){
               effects = true;
           } else if(!soundfx.isSelected()){
               effects = false;
           }
        }

    public void color(int farba) {
        this.farba = farba;
        if (farba == 0) {
            icColor[0] = new ImageIcon("obrazky/blue/o1.jpg");
            icColor[1] = new ImageIcon("obrazky/blue/o1s.jpg");
            icColor[2] = new ImageIcon("obrazky/blue/o1w.jpg");
            icColor[3] = new ImageIcon("obrazky/blue/o1s.jpg");
            icColor[4] = new ImageIcon("obrazky/blue/x1.jpg");
            icColor[5] = new ImageIcon("obrazky/blue/x1s.jpg");
            icColor[6] = new ImageIcon("obrazky/blue/x1w.jpg");
            icColor[7] = new ImageIcon("obrazky/blue/x1s.jpg");
            icColor[8] = new ImageIcon("obrazky/blue/stlacene.jpg");
            icColor[9] = new ImageIcon("obrazky/blue/tlacidlo.jpg");
        } else if (farba == 1) {
            icColor[0] = new ImageIcon("obrazky/green/o1.jpg");
            icColor[1] = new ImageIcon("obrazky/green/o1s.jpg");
            icColor[2] = new ImageIcon("obrazky/green/o1w.jpg");
            icColor[3] = new ImageIcon("obrazky/green/o1s.jpg");
            icColor[4] = new ImageIcon("obrazky/green/x1.jpg");
            icColor[5] = new ImageIcon("obrazky/green/x1s.jpg");
            icColor[6] = new ImageIcon("obrazky/green/x1w.jpg");
            icColor[7] = new ImageIcon("obrazky/green/w1s.jpg");
            icColor[8] = new ImageIcon("obrazky/green/stlacene.jpg");
            icColor[9] = new ImageIcon("obrazky/green/tlacidlo.jpg");
        } else if (farba == 2) {
            icColor[0] = new ImageIcon("obrazky/grey/o1.jpg");
            icColor[1] = new ImageIcon("obrazky/grey/o1s.jpg");
            icColor[2] = new ImageIcon("obrazky/grey/o1w.jpg");
            icColor[3] = new ImageIcon("obrazky/grey/o1s.jpg");
            icColor[4] = new ImageIcon("obrazky/grey/x1.jpg");
            icColor[5] = new ImageIcon("obrazky/grey/x1s.jpg");
            icColor[6] = new ImageIcon("obrazky/grey/x1w.jpg");
            icColor[7] = new ImageIcon("obrazky/grey/x1s.jpg");
            icColor[8] = new ImageIcon("obrazky/grey/stlacene.jpg");
            icColor[9] = new ImageIcon("obrazky/grey/tlacidlo.jpg");
        } else if (farba == 3) {
            icColor[0] = new ImageIcon("obrazky/yellow/o1.jpg");
            icColor[1] = new ImageIcon("obrazky/yellow/o1s.jpg");
            icColor[2] = new ImageIcon("obrazky/yellow/o1w.jpg");
            icColor[3] = new ImageIcon("obrazky/yellow/o1s.jpg");
            icColor[4] = new ImageIcon("obrazky/yellow/x1.jpg");
            icColor[5] = new ImageIcon("obrazky/yellow/x1s.jpg");
            icColor[6] = new ImageIcon("obrazky/yellow/x1w.jpg");
            icColor[7] = new ImageIcon("obrazky/yellow/x1s.jpg");
            icColor[8] = new ImageIcon("obrazky/yellow/stlacene.jpg");
            icColor[9] = new ImageIcon("obrazky/yellow/tlacidlo.jpg");
        }
        if (farba == 0) {
            icPlayer[0] = new ImageIcon("obrazky/blue/xturn.jpg");
            icPlayer[1] = new ImageIcon("obrazky/blue/oturn.jpg");
        } else if (farba == 1) {
            icPlayer[0] = new ImageIcon("obrazky/green/xturn.jpg");
            icPlayer[1] = new ImageIcon("obrazky/green/oturn.jpg");
        } else if (farba == 2) {
            icPlayer[0] = new ImageIcon("obrazky/grey/xturn.jpg");
            icPlayer[1] = new ImageIcon("obrazky/grey/oturn.jpg");
        } else if (farba == 3) {
            icPlayer[0] = new ImageIcon("obrazky/yellow/xturn.jpg");
            icPlayer[1] = new ImageIcon("obrazky/yellow/oturn.jpg");
        }

    }

    class MouseL extends MouseAdapter {

        int x, y;
        Clip clip;

        MouseL(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        @Override
//        public void mouseClicked(MouseEvent me) {
//
//        }
        @Override
        public void mousePressed(MouseEvent me) {
            if (effects == true) {
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("sounds/clickx.wav")));
                    clip.start();
                } catch (Exception exc) {
                }
            }

            if (field[x][y].getIcon() == icColor[9]) {
                ii++;
                t++;
                if (numberTurn == 2) {
                    if (t == 2) {
                        if (turn == true) {
                            turn = false;
                        } else if (turn == false) {
                            turn = true;
                        }
                    }
                    if (ii == 2) {
                        if (prvy == true) {
                            prvy = false;
                        } else if (prvy == false) {
                            prvy = true;
                        }
                        ii = 0;
                        t = 1;
                    }
                } else if (numberTurn == 1) {
                    if (ii == 1) {
                        if (prvy == true) {
                            prvy = false;
                            turn = true;
                        } else if (prvy == false) {
                            prvy = true;
                            turn = false;
                        }
                        ii = 0;
                    }

                }
            }
            if (field[x][y].getIcon() == icColor[4]) {
                field[x][y].setIcon(icColor[5]);
            } else if (field[x][y].getIcon() == icColor[0]) {
                field[x][y].setIcon(icColor[1]);
            } else if (field[x][y].getIcon() == icColor[6]) {
                field[x][y].setIcon(icColor[7]);
            } else if (field[x][y].getIcon() == icColor[2]) {
                field[x][y].setIcon(icColor[3]);
            } else {
                field[x][y].setIcon(icColor[8]);
                endgame++;
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {

            if (turn == true) {
                playerpics.setIcon(icPlayer[0]);
            } else if (turn == false) {
                playerpics.setIcon(icPlayer[1]);
            }
            if (field[x][y].getIcon() == icColor[8]) {
                if (prvy) {
                    field[x][y].setIcon(icColor[4]);
                } else {
                    field[x][y].setIcon(icColor[0]);
                }
            } else if (field[x][y].getIcon() == icColor[1]) {
                field[x][y].setIcon(icColor[0]);
            } else if (field[x][y].getIcon() == icColor[5]) {
                field[x][y].setIcon(icColor[4]);
            } else if (field[x][y].getIcon() == icColor[3]) {
                field[x][y].setIcon(icColor[2]);
            } else if (field[x][y].getIcon() == icColor[7]) {
                field[x][y].setIcon(icColor[6]);
            }
            GameOver();
            vyhra();
        }
////        @Override
//        public void mouseEntered(MouseEvent me) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//
//        @Override
//        public void mouseExited(MouseEvent me) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
    }

    public void vyhra() {
        for (int o = 0; o < field.length; o++) {
            for (int p = 0; p < field.length; p++) {
                if (field[o][p].getIcon() == icColor[2]) {
                    field[o][p].setIcon(icColor[0]);
                    iconset1 = true;
                } else if (field[o][p].getIcon() == icColor[6]) {
                    field[o][p].setIcon(icColor[4]);
                    iconset2 = true;
                }

                for (int i = 0; i <= field.length - TTT1; i++) {
                    for (int j = 0; j <= field[i].length - TTT1; j++) {
                        if (field[i][j].getIcon() != icColor[9] && field[i][j].getIcon() != icColor[2] && field[i][j].getIcon() != icColor[6]
                                && field[i][j].getIcon() == field[i + 1][j + 1].getIcon()
                                && field[i][j].getIcon() == field[i + 2][j + 2].getIcon()
                                && field[i][j].getIcon() == field[i + 3][j + 3].getIcon()
                                && field[i][j].getIcon() == field[i + 4][j + 4].getIcon()
                                && field[i][j].getIcon() == field[i + TTT3][j + TTT3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i + k][j + k].setIcon(icColor[6]);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                firstscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i + k][j + k].setIcon(icColor[2]);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                secondscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = field.length - 1; i > TTT2; i--) {
                    for (int j = 0; j <= field[i].length - TTT1; j++) {
                        if (field[i][j].getIcon() != icColor[9] && field[i][j].getIcon() != icColor[2] && field[i][j].getIcon() != icColor[6]
                                && field[i][j].getIcon() == field[i - 1][j + 1].getIcon()
                                && field[i][j].getIcon() == field[i - 2][j + 2].getIcon()
                                && field[i][j].getIcon() == field[i - 3][j + 3].getIcon()
                                && field[i][j].getIcon() == field[i - 4][j + 4].getIcon()
                                && field[i][j].getIcon() == field[i - TTT3][j + TTT3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i - k][j + k].setIcon(icColor[6]);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                firstscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i - k][j + k].setIcon(icColor[3]);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                secondscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = 0; i <= field.length - TTT1; i++) {
                    for (int j = 0; j < field[i].length; j++) {
                        if (field[i][j].getIcon() != icColor[9] && field[i][j].getIcon() != icColor[2] && field[i][j].getIcon() != icColor[6]
                                && field[i][j].getIcon() == field[i + 1][j].getIcon()
                                && field[i][j].getIcon() == field[i + 2][j].getIcon()
                                && field[i][j].getIcon() == field[i + 3][j].getIcon()
                                && field[i][j].getIcon() == field[i + 4][j].getIcon()
                                && field[i][j].getIcon() == field[i + TTT3][j].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i + k][j].setIcon(icColor[6]);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                firstscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i + k][j].setIcon(icColor[2]);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                secondscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j <= field[i].length - TTT1; j++) {
                        if (field[i][j].getIcon() != icColor[9] && field[i][j].getIcon() != icColor[2] && field[i][j].getIcon() != icColor[6]
                                && field[i][j].getIcon() == field[i][j + 1].getIcon()
                                && field[i][j].getIcon() == field[i][j + 2].getIcon()
                                && field[i][j].getIcon() == field[i][j + 3].getIcon()
                                && field[i][j].getIcon() == field[i][j + 4].getIcon()
                                && field[i][j].getIcon() == field[i][j + TTT3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i][j + k].setIcon(icColor[6]);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                firstscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < TTT1; k++) {
                                    field[i][j + k].setIcon(icColor[2]);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                secondscore++;
                                win = new Win(vyhra, firstscore, secondscore, farba);
                                win.setVisible(true);
                            }

                        }
                    }
                }
                //////////////////
                if (iconset1 == true) {
                    field[o][p].setIcon(icColor[2]);
                    iconset1 = false;
                } else if (iconset2 == true) {
                    field[o][p].setIcon(icColor[6]);
                    iconset2 = false;
                }
                ///////////////////////
            }
        }
    }

    public void GameOver() {

        if (endgame == (width * height)) {
            System.out.println("Game Over");
            JLabel vyhra = new JLabel("Game Over:");
            win = new Win(vyhra, firstscore, secondscore, farba);
            win.setVisible(true);
        }
    }
}
