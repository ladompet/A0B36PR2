/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Piotr04_SVK
 */
class Closer extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

public class MainMenu extends JFrame {

    JButton[][] pole;
    Field field;

//    void menu() {
//    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

    MainMenu() {
        super.setTitle("Sestvorky");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu file = new JMenu("File", true);
        menu.add(file);
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(newGame);
        file.addSeparator();
        file.add(exit);

        newGame.addActionListener(new NovaHra());
        exit.addActionListener(new Exit());
        //this.setLayout(null);
        this.setResizable(false);
        int n = 19;
        int m = n;
        field = new Field(n, m);
        this.add(field);
        int x = 30;
        this.setSize(x * (n + 1) - 24, x * (m + 1) + 22);

    }

    class NovaHra extends JDialog implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
//    public static void main(String[] args) {
//        new MainMenu().setVisible(true);
//    }
}
