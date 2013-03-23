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

    boolean hra = true;
    int farba = 0;
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
        field = new Field(n, m, hra, farba);
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
            if (hra == true) {
                MainMenu.super.setTitle("Connect6");
            } else {
                MainMenu.super.setTitle("Tic Tac Toe");
            }
            MainMenu.this.setVisible(false);
            MainMenu.this.remove(field);
            MainMenu.this.add(field = new Field(a, b, hra, farba));
            MainMenu.this.setSize(x * (a + 1) - 29, x * (b + 1) + 17);
            MainMenu.this.setVisible(true);

        }
    }

    class Nastavenia extends JDialog implements ActionListener, ItemListener {

        JTextField width, height;
        JLabel w1, h1, max, size, game, color;
        JCheckBox c6, ttt, blue, green, grey;
        ButtonGroup CB1;
        ButtonGroup CB2;
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
            CB1 = new ButtonGroup();
            CB2 = new ButtonGroup();

            w1 = new JLabel("Width");
            h1 = new JLabel("Height");
            max = new JLabel("(6-19)");
            size = new JLabel("Size of Field:");
            game = new JLabel("Game Mod:");
            color = new JLabel("Select a color:");

            width = new JTextField();
            height = new JTextField();

            c6 = new JCheckBox("Connect 6", true);
            ttt = new JCheckBox("Tic Tac Toe", false);
            blue = new JCheckBox("Blue", true);
            green = new JCheckBox("Green", false);
            grey = new JCheckBox("Grey", false);

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
            game.setBounds(100, 75, 100, 20);
            this.add(color);
            color.setBounds(100, 120, 100, 20);

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
            if (c6.isSelected()) {
                hra = true;
            } else {
                hra = false;
            }
            if (blue.isSelected()) {
                farba = 0;
            } else if (green.isSelected()) {
                farba = 1;
            } else if (grey.isSelected()) {
                farba = 2;
            }
        }
    }
}
