package morseCodeTranslator;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class morseToEnglish extends JFrame implements ActionListener {
    public static String text;
    private static final HashMap<String, Character> morseToCharMap = new HashMap<>();

    static {
        morseToCharMap.put(".-", 'A');
        morseToCharMap.put("-...", 'B');
        morseToCharMap.put("-.-.", 'C');
        morseToCharMap.put("-..", 'D');
        morseToCharMap.put(".", 'E');
        morseToCharMap.put("..-.", 'F');
        morseToCharMap.put("--.", 'G');
        morseToCharMap.put("....", 'H');
        morseToCharMap.put("..", 'I');
        morseToCharMap.put(".---", 'J');
        morseToCharMap.put("-.-", 'K');
        morseToCharMap.put(".-..", 'L');
        morseToCharMap.put("--", 'M');
        morseToCharMap.put("-.", 'N');
        morseToCharMap.put("---", 'O');
        morseToCharMap.put(".--.", 'P');
        morseToCharMap.put("--.-", 'Q');
        morseToCharMap.put(".-.", 'R');
        morseToCharMap.put("...", 'S');
        morseToCharMap.put("-", 'T');
        morseToCharMap.put("..-", 'U');
        morseToCharMap.put("...-", 'V');
        morseToCharMap.put(".--", 'W');
        morseToCharMap.put("-..-", 'X');
        morseToCharMap.put("-.--", 'Y');
        morseToCharMap.put("--..", 'Z');
        morseToCharMap.put("-----", '0');
        morseToCharMap.put(".----", '1');
        morseToCharMap.put("..---", '2');
        morseToCharMap.put("...--", '3');
        morseToCharMap.put("....-", '4');
        morseToCharMap.put(".....", '5');
        morseToCharMap.put("-....", '6');
        morseToCharMap.put("--...", '7');
        morseToCharMap.put("---..", '8');
        morseToCharMap.put("----.", '9');
        morseToCharMap.put(" ", ' '); // Space between words
    }

    JLabel l1,l2,l3;
    int i,j;
    JTextField t1,t2;
    JButton translate,logOut;
    morseToEnglish(){
        setSize(1000,400);

        l3 = new JLabel("MORSE CODE TO ENGLISH");
        l3.setBounds(320,40,450,50);
        l3.setFont(new Font("Tahoma",Font.BOLD,24));
        add(l3);

        l1 = new JLabel("Enter Morse Code");
        l1.setBounds(70,130,300,50);
        l1.setFont(new Font("Tahoma",Font.BOLD|Font.ITALIC,18));
        add(l1);

        l2 = new JLabel("English word/message");
        l2.setBounds(520,130,300,50);
        l2.setFont(new Font("Tahoma",Font.BOLD|Font.ITALIC,18));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(50,180,420,40);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(t1);

        /*t2 = new JTextField(morseToEnglish.text);
        t2.setBounds(500,180,420,40);
        t2.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(t2);*/

        translate = new JButton("Translate");
        translate.setBounds(410,280,150,35);
        translate.setFont(new Font("Tahoma",Font.BOLD,14));
        translate.addActionListener(this);
        add(translate);

        logOut = new JButton("Log out");
        logOut.setBounds(880,300,80,35);
        logOut.setBackground(Color.RED);
        logOut.setForeground(Color.WHITE);
        logOut.addActionListener(this);
        add(logOut);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//signUp.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000,400,Image.SCALE_SMOOTH);
        i1 = new ImageIcon(editedimg1);
        JLabel i2 = new JLabel(i1);
        i2.setBounds(0,0,1000,400);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static String morseToText(String morseCode) {
        StringBuilder text = new StringBuilder();

        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] symbols = word.split(" ");
            for (String symbol : symbols) {
                Character character = morseToCharMap.get(symbol);
                if (character != null) {
                    text.append(character);
                } else {
                    text.append("?"); // Handle unknown symbols
                }
            }
            text.append(' ');
        }

        return text.toString().trim();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==translate) {
            if (translate.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"ENTER THE MORSE CODE");
            }
            else {
                String morseCode = t1.getText();
                text = morseToText(morseCode);
                setVisible(true);
                JOptionPane.showMessageDialog(null,text);

                System.out.println(text);

                //JOptionPane.showMessageDialog(null,text);
                //resultArea.setText("English Text: " + text);
            }
        }
         if (ae.getSource()==logOut) {
            new login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new morseToEnglish();
    }
}

