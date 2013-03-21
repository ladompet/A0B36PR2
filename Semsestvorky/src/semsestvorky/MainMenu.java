/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

    public static int m;
    public static int n;
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
        this.setBounds(350, 0, 0, 0);
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
        JMenuItem newGame = new JMenuItem("New Game    ");
        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(newGame);
        file.addSeparator();
        file.add(settings);
        file.addSeparator();
        file.add(exit);

        newGame.addActionListener(new NovaHra());
        settings.addActionListener(new Nastavenia());
        exit.addActionListener(new Exit());
        //this.setLayout(null);
        this.setResizable(false);
        int n = 19;
        int m = n;
        field = new Field(n, m);
        this.add(field);
        int x = 35;
        this.setSize(x * (n + 1) - 24, x * (m + 1) + 22);

    }

    class NovaHra extends JDialog implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    class Nastavenia extends JDialog implements ActionListener {

        JTextField width, height;
        JLabel w1,h1, max;
        JButton ok, cancel;
        int m, n;

        Nastavenia() {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    we.getWindow().dispose();
                }
            });
            this.setTitle("Settings");
            this.setLayout(null);
            this.setLocation(550, 200);
            this.setSize(280, 150);
            this.setResizable(false);

            w1 = new JLabel("Width");
            h1 = new JLabel("Height");
            max = new JLabel("(6-19)");
            
            width = new JTextField();
            width.setEditable(false);
            height = new JTextField();
            height.setEditable(false);

            cancel = new JButton("Cancel");
            ok = new JButton("OK");

            this.add(w1);
            w1.setBounds(78, 17, 50, 20);
            this.add(h1);
            h1.setBounds(158, 17, 50, 20);
            this.add(max);
            max.setBounds(205, 35, 50, 20);
            
            this.add(width);
            width.setBounds(70, 35, 50, 20);
            this.add(height);
            height.setBounds(150, 35, 50, 20);

            this.add(ok);
            ok.setBounds(140, 70, 75, 25);
            this.add(cancel);
            cancel.setBounds(60, 70, 75, 25);

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try{
                        n=Integer.parseInt(width.getText());
                        m=Integer.parseInt(height.getText());
                        dispose();
                    }catch (Exception any){
                        width.setText("");
                        height.setText("");
                        n=6;
                        m=6;
                    }
                    new NovaHra().actionPerformed(ae);
                    Nastavenia.this.dispose();
                }
            });
            cancel.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ae) {
                    Nastavenia.this.dispose();
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Nastavenia().setVisible(true);
        }
    }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

}
