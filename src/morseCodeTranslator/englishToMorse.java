package morseCodeTranslator;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.util.HashMap;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class englishToMorse extends JFrame implements ActionListener {
    public static String morsecode;
    private static final HashMap<Character, String> charToMorseMap = new HashMap<>();

    static {
        charToMorseMap.put('A', ".-");
        charToMorseMap.put('B', "-...");
        charToMorseMap.put('C', "-.-.");
        charToMorseMap.put('D', "-..");
        charToMorseMap.put('E', ".");
        charToMorseMap.put('F', "..-.");
        charToMorseMap.put('G', "--.");
        charToMorseMap.put('H', "....");
        charToMorseMap.put('I', "..");
        charToMorseMap.put('J', ".---");
        charToMorseMap.put('K', "-.-");
        charToMorseMap.put('L', ".-..");
        charToMorseMap.put('M', "--");
        charToMorseMap.put('N', "-.");
        charToMorseMap.put('O', "---");
        charToMorseMap.put('P', ".--.");
        charToMorseMap.put('Q', "--.-");
        charToMorseMap.put('R', ".-.");
        charToMorseMap.put('S', "...");
        charToMorseMap.put('T', "-");
        charToMorseMap.put('U', "..-");
        charToMorseMap.put('V', "...-");
        charToMorseMap.put('W', ".--");
        charToMorseMap.put('X', "-..-");
        charToMorseMap.put('Y', "-.--");
        charToMorseMap.put('Z', "--..");
        charToMorseMap.put('0', "-----");
        charToMorseMap.put('1', ".----");
        charToMorseMap.put('2', "..---");
        charToMorseMap.put('3', "...--");
        charToMorseMap.put('4', "....-");
        charToMorseMap.put('5', ".....");
        charToMorseMap.put('6', "-....");
        charToMorseMap.put('7', "--...");
        charToMorseMap.put('8', "---..");
        charToMorseMap.put('9', "----.");
        charToMorseMap.put(' ', " ");
    }
    JLabel l1, l2, l3;
    //JScrollPane sp1;
    //JTable details;
    JTextField t1, t2;
    JButton translate, logOut, back;

    englishToMorse() {
        setSize(1000, 400);
        /*sp1 = new JScrollPane();
        sp1.setBounds(50,100,900,400);
        add(sp1);

        details=new JTable();
        details.setFont(new Font("tahoma",Font.PLAIN,18));
        details.setRowHeight(26);

        sp1.setViewportView(details);

        //JTableHeader tb1 = details.getTableHeader();
        //tb1.setFont(new Font("tahoma",Font.BOLD,22));
        //t1.setBackground(Color.cyan);*/

        l3 = new JLabel("ENGLISH TO MORSE CODE");
        l3.setBounds(320, 40, 450, 50);
        l3.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(l3);

        l1 = new JLabel("Enter English word/message");
        l1.setBounds(70, 130, 300, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        add(l1);

        l2 = new JLabel("Morse Code");
        l2.setBounds(520, 130, 300, 50);
        l2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(50, 180, 420, 40);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        t1.setText(t1.getText().toLowerCase());
        add(t1);


        t2 = new JTextField(englishToMorse.morsecode);
        t2.setBounds(500, 180, 420, 40);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        t2.setText(t2.getText().toLowerCase());
        add(t2);

        translate = new JButton("Translate");
        translate.setBounds(410, 280, 150, 35);
        translate.setFont(new Font("Tahoma", Font.BOLD, 14));
        translate.addActionListener(this);
        add(translate);

        logOut = new JButton("Log out");
        logOut.setBounds(880, 300, 80, 35);
        logOut.setBackground(Color.RED);
        logOut.setForeground(Color.WHITE);
        logOut.addActionListener(this);
        add(logOut);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//signUp.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000, 400, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(editedimg1);
        JLabel i2 = new JLabel(i1);
        i2.setBounds(0, 0, 1000, 400);
        add(i2);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images//backButton.png"));
        Image ef = i5.getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        back = new JButton(i5);
        back.setBounds(3, 3, 50, 30);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();

        for (char character : text.toUpperCase().toCharArray()) {
            String code = charToMorseMap.get(character);
            if (code !=null) {
                morseCode.append(code).append(" ");
            }
        }

        return morseCode.toString();
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==translate) {
            if (translate.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"enter the message");
            }else {
                String inputText = t1.getText();
                morsecode = textToMorse(inputText);
                System.out.println(morsecode);
                JOptionPane.showMessageDialog(null,morsecode);
            }
        }


        if (ae.getSource()==back) {
            new options();
            setVisible(false);

        }
        else if (ae.getSource()==logOut) {
            new login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new englishToMorse();
    }
}