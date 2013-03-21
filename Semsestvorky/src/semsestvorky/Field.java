/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import javax.swing.*;

/**
 *
 * @author Piotr04_SVK
 */
public class Field extends JPanel {

    JButton[][] pole;
    ImageIcon[] ic = new ImageIcon[8];

    Field(int n, int m){
        this.setLayout(null);
        pole = new JButton[n][m];
        
        for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pole[i][j] = new JButton();
                    pole[i][j].setIcon(ic[7]);
                    //pole[i][j].addMouseListener(new ML(i,j));
                    int x = 30;
                    pole[i][j].setBounds(x*i, x*j, x, x);
                    this.add(pole[i][j]);
                    
            }
        }
    }
    
    public void setIcon() {
        ic[0] = new ImageIcon("o1.jpg");
        ic[1] = new ImageIcon("o1s.jpg");
        ic[2] = new ImageIcon("o1w.jpg");
        ic[3] = new ImageIcon("x1.jpg");
        ic[4] = new ImageIcon("x1s.jpg");
        ic[5] = new ImageIcon("x1w.jpg");
        ic[6] = new ImageIcon("stlacene.jpg");
        ic[7] = new ImageIcon("tlacidlo.jpg");

    }
    
}

