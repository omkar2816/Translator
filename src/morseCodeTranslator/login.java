package morseCodeTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    login(){
        setSize(600,420);

        JLabel l1 = new JLabel("USERNAME");
        l1.setBounds(100,70,200,100);
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        add(l1);

        JLabel l2 = new JLabel("PASSWORD");
        l2.setBounds(100,120,200,100);
        l2.setFont(new Font("Tahoma",Font.BOLD,22));
        l2.setForeground(Color.WHITE);
        add(l2);

        username = new JTextField();
        username.setBounds(270,100,190,40);
        username.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(username);

        password = new JPasswordField();
        password.setBounds(270,150,190,40);
        password.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(password);

        login = new JButton("Log In");
        login.setBounds(350,250,110,35);
        login.setFont(new Font("Rockwell",Font.BOLD,14));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(180,250,110,35);
        cancel.setFont(new Font("Rockwell",Font.BOLD,14));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//login.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,600,420);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = this.username.getText();
            String password = Arrays.toString(this.password.getPassword());
            try{
                conn c = new conn();
                String query = "select (username) from login where username = '"+username+"'";
                c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null,"Logged In Successful");
                new options();
                this.setVisible(false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"User not found\nClick on Sign Up");
            }
        } else if (ae.getSource() == cancel) {
            new starterWindow();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
