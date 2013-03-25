/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semsestvorky;

/**
 *
 * @author Piotr04_SVK
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Win extends JDialog implements ActionListener {

    int farba;
    MainMenu mm = new MainMenu();
    JLabel winner, prvy, druhy, obr1, obr2;
    JButton newGame, cancel;
    ImageIcon icx = new ImageIcon();
    ImageIcon ico = new ImageIcon();

    Win(JLabel vyhra, int pocetprvy, int pocetdruhy, int a) {

        farba = a;
        this.setLayout(null);
        winner = vyhra;
        vyhra.setFont(new Font("Arial", Font.BOLD, 18));
        super.setTitle("Congratulations!");
        this.setLocation(550, 200);
        this.setSize(290, 150);
        this.setResizable(false);
        this.setModal(true);
        if (farba == 0) {
            icx = new ImageIcon("obrazky/blue/x1.jpg");
            ico = new ImageIcon("obrazky/blue/o1.jpg");
        } else if (farba == 1) {
            icx = new ImageIcon("obrazky/green/x1.jpg");
            ico = new ImageIcon("obrazky/green/o1.jpg");
        } else if (farba == 2) {
            icx = new ImageIcon("obrazky/grey/x1.jpg");
            ico = new ImageIcon("obrazky/grey/o1.jpg");
        }

        obr1 = new JLabel(icx, JLabel.CENTER);;
        obr2 = new JLabel(ico, JLabel.CENTER);;

        prvy = new JLabel(String.valueOf(pocetprvy));
        druhy = new JLabel(String.valueOf(pocetdruhy));

        this.add(prvy);
        prvy.setBounds(100, 42, 50, 25);
        prvy.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(druhy);
        druhy.setBounds(230, 42, 50, 25);
        druhy.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(vyhra);
        vyhra.setBounds(85, 5, 250, 25);

        this.add(obr1);
        obr1.setBounds(60, 35, 35, 35);
        this.add(obr2);
        obr2.setBounds(190, 35, 35, 35);

        cancel = new JButton("Continue");
        newGame = new JButton("New Game");
        this.add(newGame);
        newGame.setBounds(160, 82, 100, 25);
        this.add(cancel);
        cancel.setBounds(30, 82, 100, 25);

        newGame.addActionListener(new ActionListener() {
            JButton[][] pole;

            @Override
            public void actionPerformed(ActionEvent e) {
                mm.new NovaHra().actionPerformed(e);
                Win.this.dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Win.this.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}