/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

import java.awt.Color;
import java.awt.Font;
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

    boolean hra = true;
    int farba = 0;
    boolean far0 = true;
    boolean far1 = false;
    boolean far2 = false;
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
        this.setLocation(350, 0);
        this.setBackground(Color.DARK_GRAY);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu file = new JMenu("File", false);
        JMenu help = new JMenu("Help", false);

        menu.add(file);
        menu.add(help);
       
        JMenuItem newGame = new JMenuItem("New Game    ");
        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem help1 = new JMenuItem("Connect6 Help");
        JMenuItem about = new JMenuItem("About");
        file.add(newGame);
        file.addSeparator();
        file.add(settings);
        file.addSeparator();
        file.add(exit);
        help.add(help1);
        help.addSeparator();
        help.add(about);

        newGame.addActionListener(new NovaHra());
        settings.addActionListener(new Nastavenia());
        exit.addActionListener(new Exit());
        help1.addActionListener(new Help());
        about.addActionListener(new About());
//        this.setLayout(null);

        this.setResizable(false);
        field = new Field(n, m, hra, farba);
        this.add(field);
        this.setSize(x * (n + 1) - 29, x * (m + 1) + 53);

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
            if (hra == true) {
                MainMenu.super.setTitle("Connect6");
            } else {
                MainMenu.super.setTitle("Tic Tac Toe");
            }
            MainMenu.this.setVisible(false);
            MainMenu.this.remove(field);
            MainMenu.this.add(field = new Field(a, b, hra, farba));
            MainMenu.this.setSize(x * (a + 1) - 29, x * (b + 1) + 53);
            MainMenu.this.setVisible(true);

        }
    }

    class Nastavenia extends JDialog implements ActionListener, ItemListener {

        JTextField width, height;
        JLabel w1, h1, max, size, game, color;
        JCheckBox c6, ttt, blue, green, grey;
        ButtonGroup CB1, CB2;
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
            this.setSize(280, 240);
            this.setResizable(false);
            this.setModal(true);
            CB1 = new ButtonGroup();
            CB2 = new ButtonGroup();

            w1 = new JLabel("Width");
            w1.setFont(new Font("Arial", Font.ITALIC, 12));
            h1 = new JLabel("Height");
            h1.setFont(new Font("Arial", Font.ITALIC, 12));
            max = new JLabel("(6-19)");
            max.setFont(new Font("Arial", Font.ITALIC, 12));
            size = new JLabel("Size of Field:");
            game = new JLabel("Game Mod:");
            color = new JLabel("Select a color:");

            width = new JTextField();
            height = new JTextField();

            c6 = new JCheckBox("Connect 6", hra);
            c6.setFont(new Font("Arial", Font.ITALIC, 12));
            ttt = new JCheckBox("Tic Tac Toe", !hra);
            ttt.setFont(new Font("Arial", Font.ITALIC, 12));
            blue = new JCheckBox("Blue", far0);
            blue.setFont(new Font("Arial", Font.ITALIC, 12));
            green = new JCheckBox("Green", far1);
            green.setFont(new Font("Arial", Font.ITALIC, 12));
            grey = new JCheckBox("Grey", far2);
            grey.setFont(new Font("Arial", Font.ITALIC, 12));

            CB1.add(c6);
            CB1.add(ttt);
            CB2.add(blue);
            CB2.add(green);
            CB2.add(grey);

            cancel = new JButton("Cancel");
            ok = new JButton("OK");

            this.add(w1);
            w1.setBounds(72, 27, 50, 20);
            this.add(h1);
            h1.setBounds(151, 27, 50, 20);
            this.add(max);
            max.setBounds(202, 45, 50, 20);
            this.add(size);
            size.setBounds(98, 10, 100, 20);
            this.add(game);
            game.setBounds(102, 75, 100, 20);
            this.add(color);
            color.setBounds(95, 120, 100, 20);

            this.add(width);
            width.setBounds(65, 48, 50, 20);
            this.add(height);
            height.setBounds(145, 48, 50, 20);

            this.add(c6);
            c6.setBounds(40, 95, 100, 20);
            this.add(ttt);
            ttt.setBounds(140, 95, 100, 20);
            this.add(blue);
            blue.setBounds(30, 140, 70, 20);
            this.add(green);
            green.setBounds(110, 140, 70, 20);
            this.add(grey);
            grey.setBounds(190, 140, 70, 20);

            width.setEditable(true);
            height.setEditable(true);
            width.setText("10");
            height.setText("10");

            this.add(ok);
            ok.setBounds(157, 175, 75, 25);
            this.add(cancel);
            cancel.setBounds(47, 175, 75, 25);

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        n = Integer.parseInt(width.getText());
                        m = Integer.parseInt(height.getText());
                        dispose();
                    } catch (Exception any) {
                    }
                    if (n < 6) {
                        n = 6;
                    }
                    if (n > 19) {
                        n = 19;
                    }
                    if (m < 6) {
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
            c6.addItemListener(this);
            ttt.addItemListener(this);
            blue.addItemListener(this);
            green.addItemListener(this);
            grey.addItemListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Nastavenia().setVisible(true);
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (ttt.isSelected()) {
                hra = false;
            } else if (c6.isSelected()) {
                hra = true;
            }
            if (blue.isSelected()) {
                farba = 0;
                far0 = true;
                far1 = false;
                far2 = false;
            } else if (green.isSelected()) {
                farba = 1;
                far0 = false;
                far1 = true;
                far2 = false;
            } else if (grey.isSelected()) {
                farba = 2;
                far0 = false;
                far1 = false;
                far2 = true;
            }
        }
    }

    class Help extends JDialog implements ActionListener {

        JLabel help, title;

        Help() {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    we.getWindow().dispose();
                }
            });
            this.setTitle("Help");
            this.setLayout(null);
            this.setLocation(550, 200);
            this.setSize(320, 180);
            this.setResizable(false);
            this.setModal(true);

            title = new JLabel("The rules of Connect6: ");
            title.setBounds(95, 5, 200, 25);
            this.add(title);
            help = new JLabel("<html> Is't game two players. Basics of the game is connect<br>"
                    + " your symbols to the 6-member family. Symbols can be<br>"
                    + " linked vertically horizontally or diagonally. First player<br>"
                    + " starts with one symbol and then both of players have two<br> "
                    + " symbols in one move. Win player that will link 6 symbols first<html>");
            help.setFont(new Font("Arial", Font.ITALIC, 12));
            help.setBounds(5, 5, 310, 150);
            this.add(help);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Help().setVisible(true);
        }
    }

    class About extends JDialog implements ActionListener {

        JLabel about0, about1, about2;

        About() {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    we.getWindow().dispose();
                }
            });
            this.setTitle("About");
            this.setLayout(null);
            this.setLocation(550, 200);
            this.setSize(280, 180);
            this.setResizable(false);
            this.setModal(true);

            about0 = new JLabel("CONNECT6 version 1.0");
            about1 = new JLabel("Built 23.3.2013");
            about2 = new JLabel("Copyright(C) Peter Ladomirjak 2013");

            this.add(about0);
            about0.setBounds(60, 20, 250, 25);
            about0.setFont(new Font("Arial", Font.BOLD, 14));
            this.add(about1);
            about1.setBounds(100, 40, 100, 25);
            about1.setFont(new Font("Arial", Font.ITALIC, 12));
            this.add(about2);
            about2.setBounds(40, 80, 200, 25);
            about2.setFont(new Font("Arial", Font.ITALIC, 12));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new About().setVisible(true);
        }
    }
}
