package morseCodeTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starterWindow extends JFrame implements ActionListener {
    JButton old,new1;
    starterWindow() {
        setSize(700, 550);

        JLabel l1 = new JLabel("MORSE CODE TRANSLATOR");
        l1.setBounds(135, 75, 650, 150);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setForeground(Color.BLACK);
        add(l1);

        new1 = new JButton("Sign Up");
        new1.setBounds(160,380,130,35);
        new1.setFont(new Font("Rockwell",Font.BOLD,14));
        new1.addActionListener(this);
        add(new1);

        old = new JButton("Next");
        old.setBounds(400, 380, 130, 35);
        old.setFont(new Font("Rockwell", Font.BOLD, 14));
        old.addActionListener(this);
        add(old);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//starter.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(700,550,Image.SCALE_SMOOTH);
        i1 = new ImageIcon(editedimg1);
        JLabel i2 = new JLabel(i1);
        i2.setBounds(0,0,700,550);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == old){
            new login();
            this.setVisible(false);
        } else if (ae.getSource() == new1) {
            new signUp();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starterWindow();
    }
}

