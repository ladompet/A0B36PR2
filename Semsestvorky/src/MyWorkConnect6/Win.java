/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyWorkConnect6;

/**
 *
 * @author Piotr04_SVK
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Win extends JDialog implements ActionListener {

    JLabel winner, prvy, druhy, obr1, obr2;
    JButton Exit, cancel;
    ImageIcon icx = new ImageIcon();
    ImageIcon ico = new ImageIcon();

    Win(JLabel win, int firstscore, int secondscore, int color) {

        this.setLayout(null);
        winner = win;
        win.setFont(new Font("Arial", Font.BOLD, 18));
        super.setTitle("Congratulations!");
        this.setLocation(550, 200);
        this.setSize(290, 150);
        this.setResizable(false);
        this.setModal(true);
        if (color == 0) {
            icx = new ImageIcon("obrazky/blue/x1.jpg");
            ico = new ImageIcon("obrazky/blue/o1.jpg");
        } else if (color == 1) {
            icx = new ImageIcon("obrazky/green/x1.jpg");
            ico = new ImageIcon("obrazky/green/o1.jpg");
        } else if (color == 2) {
            icx = new ImageIcon("obrazky/grey/x1.jpg");
            ico = new ImageIcon("obrazky/grey/o1.jpg");
        } else if (color == 3) {
            icx = new ImageIcon("obrazky/yellow/x1.jpg");
            ico = new ImageIcon("obrazky/yellow/o1.jpg");
        }

        obr1 = new JLabel(icx, JLabel.CENTER);;
        obr2 = new JLabel(ico, JLabel.CENTER);;

        prvy = new JLabel(String.valueOf(firstscore));
        druhy = new JLabel(String.valueOf(secondscore));

        this.add(prvy);
        prvy.setBounds(100, 42, 50, 25);
        prvy.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(druhy);
        druhy.setBounds(230, 42, 50, 25);
        druhy.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(win);
        win.setBounds(72, 5, 250, 25);

        this.add(obr1);
        obr1.setBounds(60, 35, 35, 35);
        this.add(obr2);
        obr2.setBounds(190, 35, 35, 35);

        cancel = new JButton("Continue");
        Exit = new JButton("Exit Game");
        this.add(Exit);
        Exit.setBounds(160, 82, 100, 25);
        this.add(cancel);
        cancel.setBounds(30, 82, 100, 25);

        Exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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