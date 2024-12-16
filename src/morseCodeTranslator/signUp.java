package morseCodeTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class signUp extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JButton back,signIn;
    JTextField name,email,username;
    JPasswordField password1;
    signUp() {
        setSize(600,450);

        l1 = new JLabel("Name:");
        l1.setBounds(100,50,100,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l1);

        l2 = new JLabel("Email:");
        l2.setBounds(100,100,100,50);
        l2.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l2);

        l3 = new JLabel("Username:");
        l3.setBounds(100,150,200,50);
        l3.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l3);

        l4 = new JLabel("Password:");
        l4.setBounds(100,200,200,50);
        l4.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l4);

        name = new JTextField();
        name.setBounds(250,58,220,35);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(name);

        email = new JTextField();
        email.setBounds(250,108,220,35);
        email.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(email);

        username = new JTextField();
        username.setBounds(250,160,220,35);
        username.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(username);

        password1 = new JPasswordField();
        password1.setBounds(250,210,220,35);
        password1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(password1);

        back = new JButton("Back");
        back.setBounds(150,300,130,35);
        back.setFont(new Font("Rockwell",Font.BOLD,14));
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        signIn = new JButton("Sign Up");
        signIn.setBounds(300,300,130,35);
        signIn.setFont(new Font("Rockwell",Font.BOLD,14));
        signIn.addActionListener(this);
        add(signIn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//signUp.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(600,450,Image.SCALE_SMOOTH);
        i1 = new ImageIcon(editedimg1);
        JLabel i2 = new JLabel(i1);
        i2.setBounds(0,0,600,450);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signIn){
            if (name.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"ENTERR YOUR NAME");
            } else if (email.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"ENTER YOUR EMAIL");
            } else if (username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"ENTER YOR USERNAME");
            } else if (password1.getPassword().equals(null)) {
                JOptionPane.showMessageDialog(null,"ENTER YOUR PASSWORD");
            }
            String name = this.name.getText();
            String email = this.email.getText();
            String username = this.username.getText();
            String password = this.password1.getText();
            conn c = new conn();

            String query1 = "insert into details (name,email,username) values('"+name+"','"+email+"','"+username+"');";
            String query2 = "insert into login (username,password) values ('"+username+"','"+password+"')";
            try{
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Registered Successfully");
                new login();
                this.setVisible(false);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Registeration Failed");
            }
        } else if (ae.getSource() == back) {
            new starterWindow();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new signUp();
    }
}

