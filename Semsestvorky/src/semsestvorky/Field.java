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
                pole[i][j].addMouseListener(new MouseL(i,j));
                int x = 35;
                pole[i][j].setBounds(x * i, x * j, x, x);
                this.add(pole[i][j]);

            }
        }
    }
    private class MouseL extends MouseAdapter{
        
               int x, y;

        MouseL(int x, int y) {
            this.x = x;
            this.y = y;
        }  
        
   
      @Override
          public void mouseClicked(MouseEvent me) {
      }    
        
    }
}
