/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static semsestvorky.MainMenu.x;

/**
 *
 * @author Piotr04_SVK
 */
public class Field extends JPanel {

    boolean hra;
    boolean effects;
    int farba;
    int pocet;
    int pocetturn;
    int pocetprvy = 0;
    int pocetdruhy = 0;
    boolean iconset1 = false;
    boolean iconset2 = false;
    boolean vyherca;
    boolean prvy = true;
    int sp;
    int sp2;
    int sp3;
    int ii = 0;
    int t = 1;
    boolean turn = true;
    Win win;
    JButton[][] pole;
    ImageIcon ic1 = new ImageIcon();
    ImageIcon ic2 = new ImageIcon();
    ImageIcon ic3 = new ImageIcon();
    ImageIcon ic4 = new ImageIcon();
    ImageIcon ic5 = new ImageIcon();
    ImageIcon ic6 = new ImageIcon();
    ImageIcon ic7 = new ImageIcon();
    ImageIcon ic8 = new ImageIcon();
    ImageIcon icxs = new ImageIcon();
    ImageIcon icos = new ImageIcon();
    ImageIcon ichrac1 = new ImageIcon();
    ImageIcon ichrac2 = new ImageIcon();
    JButton hracobr = new JButton();

    Field(int n, int m, boolean c, int d, boolean fx) {
        effects = fx;
        hra = c;
        if (hra == true) {
            pocet = 2;
            sp = 6;
            sp2 = 4;
            sp3 = 5;
        } else if (hra == false) {
            prvy = false;
            sp = 5;
            sp2 = 3;
            sp3 = 1;
            pocet = 1;
        }
        farba = d;
        if (farba == 0) {
            ic1 = new ImageIcon("obrazky/blue/o1.jpg");
            ic2 = new ImageIcon("obrazky/blue/o1s.jpg");
            ic3 = new ImageIcon("obrazky/blue/o1w.jpg");
            icos = new ImageIcon("obrazky/blue/o1s.jpg");
            ic4 = new ImageIcon("obrazky/blue/x1.jpg");
            ic5 = new ImageIcon("obrazky/blue/x1s.jpg");
            ic6 = new ImageIcon("obrazky/blue/x1w.jpg");
            icxs = new ImageIcon("obrazky/blue/x1s.jpg");
            ic7 = new ImageIcon("obrazky/blue/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/blue/tlacidlo.jpg");
        } else if (farba == 1) {
            ic1 = new ImageIcon("obrazky/green/o1.jpg");
            ic2 = new ImageIcon("obrazky/green/o1s.jpg");
            ic3 = new ImageIcon("obrazky/green/o1w.jpg");
            icos = new ImageIcon("obrazky/green/o1s.jpg");
            ic4 = new ImageIcon("obrazky/green/x1.jpg");
            ic5 = new ImageIcon("obrazky/green/x1s.jpg");
            ic6 = new ImageIcon("obrazky/green/x1w.jpg");
            icxs = new ImageIcon("obrazky/green/w1s.jpg");
            ic7 = new ImageIcon("obrazky/green/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/green/tlacidlo.jpg");
        } else if (farba == 2) {
            ic1 = new ImageIcon("obrazky/grey/o1.jpg");
            ic2 = new ImageIcon("obrazky/grey/o1s.jpg");
            ic3 = new ImageIcon("obrazky/grey/o1w.jpg");
            icos = new ImageIcon("obrazky/grey/o1s.jpg");
            ic4 = new ImageIcon("obrazky/grey/x1.jpg");
            ic5 = new ImageIcon("obrazky/grey/x1s.jpg");
            ic6 = new ImageIcon("obrazky/grey/x1w.jpg");
            icxs = new ImageIcon("obrazky/grey/x1s.jpg");
            ic7 = new ImageIcon("obrazky/grey/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/grey/tlacidlo.jpg");
        } else if (farba == 3) {
            ic1 = new ImageIcon("obrazky/yellow/o1.jpg");
            ic2 = new ImageIcon("obrazky/yellow/o1s.jpg");
            ic3 = new ImageIcon("obrazky/yellow/o1w.jpg");
            icos = new ImageIcon("obrazky/yellow/o1s.jpg");
            ic4 = new ImageIcon("obrazky/yellow/x1.jpg");
            ic5 = new ImageIcon("obrazky/yellow/x1s.jpg");
            ic6 = new ImageIcon("obrazky/yellow/x1w.jpg");
            icxs = new ImageIcon("obrazky/yellow/x1s.jpg");
            ic7 = new ImageIcon("obrazky/yellow/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/yellow/tlacidlo.jpg");
        }
        if (farba == 0) {
            ichrac1 = new ImageIcon("obrazky/blue/xturn.jpg");
            ichrac2 = new ImageIcon("obrazky/blue/oturn.jpg");
        } else if (farba == 1) {
            ichrac1 = new ImageIcon("obrazky/green/xturn.jpg");
            ichrac2 = new ImageIcon("obrazky/green/oturn.jpg");
        } else if (farba == 2) {
            ichrac1 = new ImageIcon("obrazky/grey/xturn.jpg");
            ichrac2 = new ImageIcon("obrazky/grey/oturn.jpg");
        } else if (farba == 3) {
            ichrac1 = new ImageIcon("obrazky/yellow/xturn.jpg");
            ichrac2 = new ImageIcon("obrazky/yellow/oturn.jpg");
        }

        JLabel hrac = new JLabel("TURN :");
        Panel p = new Panel();
        p.setBounds(0, x * m, x * n * 2, 50);

        p.add(hrac);
        hrac.setBounds(((x * n) / 2) - 33, x * m, 75, 25);
        hrac.setFont(new Font("Arial", Font.BOLD, 12));
        hrac.setForeground(Color.BLACK);
        this.add(hrac);

        p.add(hracobr);
        hracobr.setIcon(ichrac1);
        hracobr.setBounds(((x * n) / 2) + 12, x * m, 26, 26);
        this.add(hracobr);

        this.add(p);
        this.setBackground(Color.GRAY);
        this.setLayout(null);

        pole = new JButton[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pole[i][j] = new JButton(ic8);
                pole[i][j].addMouseListener(new MouseL(i, j));
                int x = 35;
                pole[i][j].setBounds(x * i, x * j, x, x);
                this.add(pole[i][j]);
            }
        }
    }

    class MouseL extends MouseAdapter {

        int x, y;
        private Clip clip;

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

            if (pole[x][y].getIcon() == ic8) {
                ii++;
                t++;
                if (pocet == 2) {
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
                } else if (pocet == 1) {
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
            if (pole[x][y].getIcon() == ic4) {
                pole[x][y].setIcon(ic5);
            } else if (pole[x][y].getIcon() == ic1) {
                pole[x][y].setIcon(ic2);
            } else if (pole[x][y].getIcon() == ic6) {
                pole[x][y].setIcon(icxs);
            } else if (pole[x][y].getIcon() == ic3) {
                pole[x][y].setIcon(icos);
            } else {
                pole[x][y].setIcon(ic7);
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {

            if (turn == true) {
                hracobr.setIcon(ichrac1);
            } else if (turn == false) {
                hracobr.setIcon(ichrac2);
            }
            if (pole[x][y].getIcon() == ic7) {
                if (prvy) {
                    pole[x][y].setIcon(ic4);
                } else {
                    pole[x][y].setIcon(ic1);
                }
            } else if (pole[x][y].getIcon() == ic2) {
                pole[x][y].setIcon(ic1);
            } else if (pole[x][y].getIcon() == ic5) {
                pole[x][y].setIcon(ic4);
            } else if (pole[x][y].getIcon() == icos) {
                pole[x][y].setIcon(ic3);
            } else if (pole[x][y].getIcon() == icxs) {
                pole[x][y].setIcon(ic6);
            }
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
        for (int o = 0; o < pole.length; o++) {
            for (int p = 0; p < pole.length; p++) {
                if (pole[o][p].getIcon() == ic3) {
                    pole[o][p].setIcon(ic1);
                    iconset1 = true;
                }else if (pole[o][p].getIcon() == ic6) {
                    pole[o][p].setIcon(ic4);
                    iconset2 = true;
                }

                for (int i = 0; i <= pole.length - sp; i++) {
                    for (int j = 0; j <= pole[i].length - sp; j++) {
                        if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                                && pole[i][j].getIcon() == pole[i + 1][j + 1].getIcon()
                                && pole[i][j].getIcon() == pole[i + 2][j + 2].getIcon()
                                && pole[i][j].getIcon() == pole[i + 3][j + 3].getIcon()
                                && pole[i][j].getIcon() == pole[i + 4][j + 4].getIcon()
                                && pole[i][j].getIcon() == pole[i + sp3][j + sp3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < sp; k++) {
                                    pole[i + k][j + k].setIcon(ic6);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                pocetprvy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < sp; k++) {
                                    pole[i + k][j + k].setIcon(ic3);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                pocetdruhy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = pole.length - 1; i > sp2; i--) {
                    for (int j = 0; j <= pole[i].length - sp; j++) {
                        if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                                && pole[i][j].getIcon() == pole[i - 1][j + 1].getIcon()
                                && pole[i][j].getIcon() == pole[i - 2][j + 2].getIcon()
                                && pole[i][j].getIcon() == pole[i - 3][j + 3].getIcon()
                                && pole[i][j].getIcon() == pole[i - 4][j + 4].getIcon()
                                && pole[i][j].getIcon() == pole[i - sp3][j + sp3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < sp; k++) {
                                    pole[i - k][j + k].setIcon(ic6);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                pocetprvy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < sp; k++) {
                                    pole[i - k][j + k].setIcon(ic3);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                pocetdruhy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = 0; i <= pole.length - sp; i++) {
                    for (int j = 0; j < pole[i].length; j++) {
                        if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                                && pole[i][j].getIcon() == pole[i + 1][j].getIcon()
                                && pole[i][j].getIcon() == pole[i + 2][j].getIcon()
                                && pole[i][j].getIcon() == pole[i + 3][j].getIcon()
                                && pole[i][j].getIcon() == pole[i + 4][j].getIcon()
                                && pole[i][j].getIcon() == pole[i + sp3][j].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < sp; k++) {
                                    pole[i + k][j].setIcon(ic6);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                pocetprvy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < sp; k++) {
                                    pole[i + k][j].setIcon(ic3);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                pocetdruhy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            }
                        }
                    }
                }
                for (int i = 0; i < pole.length; i++) {
                    for (int j = 0; j <= pole[i].length - sp; j++) {
                        if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                                && pole[i][j].getIcon() == pole[i][j + 1].getIcon()
                                && pole[i][j].getIcon() == pole[i][j + 2].getIcon()
                                && pole[i][j].getIcon() == pole[i][j + 3].getIcon()
                                && pole[i][j].getIcon() == pole[i][j + 4].getIcon()
                                && pole[i][j].getIcon() == pole[i][j + sp3].getIcon()) {
                            if (prvy) {
                                for (int k = 0; k < sp; k++) {
                                    pole[i][j + k].setIcon(ic6);
                                }
                                JLabel vyhra = new JLabel("1. player win!");
                                pocetprvy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            } else {
                                for (int k = 0; k < sp; k++) {
                                    pole[i][j + k].setIcon(ic3);
                                }
                                JLabel vyhra = new JLabel("2. player win!");
                                pocetdruhy++;
                                win = new Win(vyhra, pocetprvy, pocetdruhy, farba);
                                win.setVisible(true);
                            }

                        }
                    }
                }
                //////////////////
                if (iconset1 == true) {
                    pole[o][p].setIcon(ic3);
                    iconset1 = false;
                }else if (iconset2 == true) {
                    pole[o][p].setIcon(ic6);
                    iconset2=false;
                }
                ///////////////////////
            }
        }
    }
}
