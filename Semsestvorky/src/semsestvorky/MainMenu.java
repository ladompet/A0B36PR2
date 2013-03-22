/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

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

    public static int m = 10;
    public static int n = 10;
    public static int a = 10;
    public static int b = 10;
    public static int x = 35;
    Nastavenia options = new Nastavenia();
    JButton[][] pole;
    Field field;

    MainMenu() {
        super.setTitle("Connect6");
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
        field = new Field(n, m);
        this.add(field);
        this.setSize(x * (n + 1) - 29, x * (m + 1) + 17);

    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

    class NovaHra implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.setVisible(false);
            MainMenu.this.remove(field);
            MainMenu.this.add(field = new Field(a, b));
            MainMenu.this.setSize(x * (a + 1) - 29, x * (b + 1) + 17);
            MainMenu.this.setVisible(true);

        }
    }

    class Nastavenia extends JDialog implements ActionListener {

        JTextField width, height;
        JLabel w1, h1, max;
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

            width.setEditable(true);
            height.setEditable(true);

            this.add(ok);
            ok.setBounds(140, 70, 75, 25);
            this.add(cancel);
            cancel.setBounds(60, 70, 75, 25);

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        n = Integer.parseInt(width.getText());
                        m = Integer.parseInt(height.getText());
                        dispose();
                    } catch (Exception any) {
                    }
                    if (n < 6 ) {
                        n = 6;
                    }
                    if (n > 19) {
                        n = 19;
                    }
                    if (m < 6 ) {
                        m = 6;
                    }
                    if (m > 19) {
                        m = 19;
                    }
                    a = n;
                    b = m;
                    new NovaHra().actionPerformed(ae);
                    Nastavenia.this.dispose();
                }
            });
            cancel.addActionListener(new ActionListener() {
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
}
