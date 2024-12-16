package morseCodeTranslator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn{
    Connection c;
    Statement s;

    conn() {
        String username = "root";
        String password = "Omkar@2802#";
        String url = "jdbc:mysql://localhost:3306/morse";
        try {
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
            System.out.println("CONNECTION SUCCESSFUL ;)");

        } catch (Exception e) {
            System.out.println("CONNECTION FAILED :/"+e);
        }
    }

    public static void main(String[] args) {
        new conn();
}

}