/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Piotr04_SVK
 */
public class Field extends JPanel {

    int pocetprvy = 0;
    int pocetdruhy = 0;
    boolean vyherca;
    boolean prvy = true;
    int ii = 0;
    Win win;
    JButton[][] pole;
    ImageIcon ic1 = new ImageIcon("obrazky/o1.jpg");
    ImageIcon ic2 = new ImageIcon("obrazky/o1s.jpg");
    ImageIcon ic3 = new ImageIcon("obrazky/o1w.jpg");
    ImageIcon ic4 = new ImageIcon("obrazky/x1.jpg");
    ImageIcon ic5 = new ImageIcon("obrazky/x1s.jpg");
    ImageIcon ic6 = new ImageIcon("obrazky/x1w.jpg");
    ImageIcon ic7 = new ImageIcon("obrazky/stlacene.jpg");
    ImageIcon ic8 = new ImageIcon("obrazky/tlacidlo.jpg");

    Field(int n, int m) {
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
            if (pole[x][y].getIcon() == ic8) {
                ii++;
                if (ii == 2) {
                    if (prvy == true) {
                        prvy = false;
                    } else if (prvy == false) {
                        prvy = true;
                    }
                    ii = 0;
                }
            }
            if (pole[x][y].getIcon() == ic4) {
                pole[x][y].setIcon(ic5);
            } else if (pole[x][y].getIcon() == ic1) {
                pole[x][y].setIcon(ic2);
            } else {
                pole[x][y].setIcon(ic7);
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (pole[x][y].getIcon() == ic7) {
                if (prvy) {
                    pole[x][y].setIcon(ic4);
                } else {
                    pole[x][y].setIcon(ic1);
                }
            } else if (pole[x][y].getIcon() == ic2) {
                pole[x][y].setIcon(ic1);
            } else {
                pole[x][y].setIcon(ic4);
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

        for (int i = 0; i <= pole.length - 6; i++) {
            for (int j = 0; j <= pole[i].length - 6; j++) {
                if (pole[i][j].getIcon() != ic8
                        && pole[i][j].getIcon() == pole[i + 1][j + 1].getIcon()
                        && pole[i][j].getIcon() == pole[i + 2][j + 2].getIcon()
                        && pole[i][j].getIcon() == pole[i + 3][j + 3].getIcon()
                        && pole[i][j].getIcon() == pole[i + 4][j + 4].getIcon()
                        && pole[i][j].getIcon() == pole[i + 5][j + 5].getIcon()) {
                    if (prvy) {
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j + k].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    } else {
                        vyherca = false;
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = pole.length - 1; i > 5; i--) {
            for (int j = 0; j <= pole[i].length - 6; j++) {
                if (pole[i][j].getIcon() != ic8
                        && pole[i][j].getIcon() == pole[i - 1][j + 1].getIcon()
                        && pole[i][j].getIcon() == pole[i - 2][j + 2].getIcon()
                        && pole[i][j].getIcon() == pole[i - 3][j + 3].getIcon()
                        && pole[i][j].getIcon() == pole[i - 4][j + 4].getIcon()
                        && pole[i][j].getIcon() == pole[i - 5][j + 5].getIcon()) {
                    if (prvy) {
                        vyherca = true;
                        for (int k = 0; k < 6; k++) {
                            pole[i - k][j + k].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    } else {
                        vyherca = false;
                        for (int k = 0; k < 6; k++) {
                            pole[i - k][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = 0; i <= pole.length - 6; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if (pole[i][j].getIcon() != ic8
                        && pole[i][j].getIcon() == pole[i + 1][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 2][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 3][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 4][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 5][j].getIcon()) {
                    if (prvy) {
                        vyherca = true;
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    } else {
                        vyherca = false;
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j <= pole[i].length - 6; j++) {
                if (pole[i][j].getIcon() != ic8
                        && pole[i][j].getIcon() == pole[i][j + 1].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 2].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 3].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 4].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 5].getIcon()) {
                    if (prvy) {
                        vyherca = true;
                        for (int k = 0; k < 6; k++) {
                            pole[i][j + k].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    } else {
                        vyherca = false;
                        for (int k = 0; k < 6; k++) {
                            pole[i][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy);
                        win.setVisible(true);
                    }

                }
            }
        }
    }
}
