package api;

import com.password4j.Hash;
import com.password4j.Password;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
    public static void register(String username, String password) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM USERS WHERE username = '" + username + "'";
        try(Statement checkStmt = JDBC.client.createStatement()){
            ResultSet resultSet = checkStmt.executeQuery(checkQuery);
            resultSet.next();
            int userCount = resultSet.getInt(1);
            if (userCount > 0) {
                System.out.println("User already exists.");
                JOptionPane.showMessageDialog(null, "User already exists");
                return;
            }

            Hash hash = Password.hash(password).addRandomSalt(12).withScrypt();
            String pass = hash.getResult();
            String query = "INSERT INTO USERS (username, password) VALUES ('" + username + "', '" + pass + "')";
            try (Statement stmt = JDBC.client.createStatement()) {
                int rowsAffected = stmt.executeUpdate(query);
                if (rowsAffected > 0) {

                    System.out.println("User successfully inserted.");
//                    JPanel panel = new JPanel();
//                    panel.setBackground(Color.BLUE);

                    // Mengatur warna teks yang diinginkan untuk panel
//                    UIManager.put("OptionPane.messageForeground", Color.GRAY);

                    // Menampilkan pesan dialog menggunakan JOptionPane dengan panel kustom
//                    JOptionPane.showMessageDialog(null, panel, "Register Success", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Register Success");
                } else {
                    System.out.println("Failed to insert user.");
                    JOptionPane.showMessageDialog(null, "Register failed");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
