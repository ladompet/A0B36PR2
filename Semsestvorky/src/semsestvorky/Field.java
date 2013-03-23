/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Piotr04_SVK
 */
public class Field extends JPanel {

    boolean hra;
    int farba;
    int pocet;
    int pocetprvy = 0;
    int pocetdruhy = 0;
    boolean vyherca;
    boolean prvy = true;
    int ii = 0;
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

    Field(int n, int m, boolean a, int b) {
        hra = a;
        if (hra ==true) {
            pocet =2;
        }else if (hra ==false) {
            pocet =1;
        }
        farba = b;
        if (farba == 0) {
            ic1 = new ImageIcon("obrazky/blue/o1.jpg");
            ic2 = new ImageIcon("obrazky/blue/o1s.jpg");
            ic3 = new ImageIcon("obrazky/blue/o1w.jpg");
            ic4 = new ImageIcon("obrazky/blue/x1.jpg");
            ic5 = new ImageIcon("obrazky/blue/x1s.jpg");
            ic6 = new ImageIcon("obrazky/blue/x1w.jpg");
            ic7 = new ImageIcon("obrazky/blue/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/blue/tlacidlo.jpg");
        } else if (farba == 1) {
            ic1 = new ImageIcon("obrazky/green/o1.jpg");
            ic2 = new ImageIcon("obrazky/green/o1s.jpg");
            ic3 = new ImageIcon("obrazky/green/o1w.jpg");
            ic4 = new ImageIcon("obrazky/green/x1.jpg");
            ic5 = new ImageIcon("obrazky/green/x1s.jpg");
            ic6 = new ImageIcon("obrazky/green/x1w.jpg");
            ic7 = new ImageIcon("obrazky/green/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/green/tlacidlo.jpg");
        }else if (farba == 2) {
            ic1 = new ImageIcon("obrazky/grey/o1.jpg");
            ic2 = new ImageIcon("obrazky/grey/o1s.jpg");
            ic3 = new ImageIcon("obrazky/grey/o1w.jpg");
            ic4 = new ImageIcon("obrazky/grey/x1.jpg");
            ic5 = new ImageIcon("obrazky/grey/x1s.jpg");
            ic6 = new ImageIcon("obrazky/grey/x1w.jpg");
            ic7 = new ImageIcon("obrazky/grey/stlacene.jpg");
            ic8 = new ImageIcon("obrazky/grey/tlacidlo.jpg");
        }
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
                if (ii == pocet) {
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
                if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
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
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    } else {
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = pole.length - 1; i > 5; i--) {
            for (int j = 0; j <= pole[i].length - 6; j++) {
                if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                        && pole[i][j].getIcon() == pole[i - 1][j + 1].getIcon()
                        && pole[i][j].getIcon() == pole[i - 2][j + 2].getIcon()
                        && pole[i][j].getIcon() == pole[i - 3][j + 3].getIcon()
                        && pole[i][j].getIcon() == pole[i - 4][j + 4].getIcon()
                        && pole[i][j].getIcon() == pole[i - 5][j + 5].getIcon()) {
                    if (prvy) {
                        for (int k = 0; k < 6; k++) {
                            pole[i - k][j + k].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    } else {
                        for (int k = 0; k < 6; k++) {
                            pole[i - k][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = 0; i <= pole.length - 6; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                        && pole[i][j].getIcon() == pole[i + 1][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 2][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 3][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 4][j].getIcon()
                        && pole[i][j].getIcon() == pole[i + 5][j].getIcon()) {
                    if (prvy) {
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    } else {
                        for (int k = 0; k < 6; k++) {
                            pole[i + k][j].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    }
                }
            }
        }
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j <= pole[i].length - 6; j++) {
                if (pole[i][j].getIcon() != ic8 && pole[i][j].getIcon() != ic3 && pole[i][j].getIcon() != ic6
                        && pole[i][j].getIcon() == pole[i][j + 1].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 2].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 3].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 4].getIcon()
                        && pole[i][j].getIcon() == pole[i][j + 5].getIcon()) {
                    if (prvy) {
                        for (int k = 0; k < 6; k++) {
                            pole[i][j + k].setIcon(ic6);
                        }
                        JLabel vyhra = new JLabel("1. player - You're better!");
                        pocetprvy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    } else {
                        for (int k = 0; k < 6; k++) {
                            pole[i][j + k].setIcon(ic3);
                        }
                        JLabel vyhra = new JLabel("2. player - You're better!");
                        pocetdruhy++;
                        win = new Win(vyhra, pocetprvy, pocetdruhy,farba);
                        win.setVisible(true);
                    }

                }
            }
        }
    }
}
