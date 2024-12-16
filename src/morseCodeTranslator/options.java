package morseCodeTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {
    JLabel l1;
    JButton engToMorse,morseToEng;
    options(){
        setSize(1000,300);

        engToMorse = new JButton("English to Morse Code");
        engToMorse.setBounds(150,100,350,50);
        engToMorse.setFont(new Font("Tahoma",Font.BOLD,14));
        engToMorse.addActionListener(this);
        add(engToMorse);

        morseToEng = new JButton("Morse code to English");
        morseToEng.setBounds(530,100,350,50);
        morseToEng.setFont(new Font("Tahoma",Font.BOLD,14));
        morseToEng.addActionListener(this);
        add(morseToEng);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//signUp.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000,300,Image.SCALE_SMOOTH);
        i1 = new ImageIcon(editedimg1);
        JLabel i2 = new JLabel(i1);
        i2.setBounds(0,0,1000,300);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==engToMorse){
            new englishToMorse();
            this.setVisible(false);
        }
        else if(ae.getSource()==morseToEng){
            new morseToEnglish();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new options();
    }
}
