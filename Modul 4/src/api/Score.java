package api;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Score {
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<Integer> highscores = new ArrayList<>();

    public static void updateScore(int wpmScore) throws SQLException {
        String query = "UPDATE score SET score = COALESCE(array_append(score,"+wpmScore+" ), ARRAY["+wpmScore+"]) WHERE player_id = '" + JDBC.user_id + "'";
        System.out.println("hhhhhmmm "+wpmScore);
        try (Statement stmt = JDBC.client.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Integer[] getScore() throws SQLException {
        String query = "SELECT score FROM score WHERE player_id = '" + JDBC.user_id + "'";
        try (Statement stmt = JDBC.client.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                if (rs.getArray("score") == null){
                    return null;
                }else{
                    return (Integer[]) rs.getArray("score").getArray();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static int getHighScore() throws SQLException {
        String query = "SELECT highscore FROM score WHERE player_id = '" + JDBC.user_id + "'";
        try (Statement stmt = JDBC.client.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void getUserScore() throws SQLException {
        String query = "SELECT u.username, s.highscore FROM users u INNER JOIN score s ON u.id = s.player_id ORDER BY s.highscore DESC";

        try (Statement stmt = JDBC.client.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                usernames.add(rs.getString("username"));
                highscores.add(rs.getInt("highscore"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
