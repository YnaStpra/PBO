package api;

import com.password4j.Hash;
import com.password4j.Password;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    public static boolean isLogin = false;
    public static void login(String username, String password) throws SQLException {
        Hash hash = Password.hash(password).addRandomSalt(12).withScrypt();
        String pass = hash.getResult();
        String query = "SELECT DISTINCT * FROM USERS WHERE username = '" + username +"'";
        try (Statement stmt = JDBC.client.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                JDBC.setUser_id(rs.getString("id"));
                String passDB = rs.getString("password");
                if (Password.check(password, passDB).withScrypt()) {
                    System.out.println("Login success.");
                    JOptionPane.showMessageDialog(null, "Login success");
                    isLogin = true;
                } else {
                    System.out.println("Login failed.");
                    JOptionPane.showMessageDialog(null, "Login failed");
                }
            } else {
                System.out.println("Login failed.");
                JOptionPane.showMessageDialog(null, "Login failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
