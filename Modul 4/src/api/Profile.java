package api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Profile {
    public static String getUsername()throws SQLException{
        String query = "SELECT DISTINCT * FROM USERS WHERE id = '" + JDBC.user_id +"'";
        try (Statement stmt = JDBC.client.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
