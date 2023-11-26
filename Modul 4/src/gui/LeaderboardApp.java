package gui;

import api.Profile;
import api.Score;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

public class LeaderboardApp extends JFrame {
    private String[] username;
    private Integer[] highscore;

    public LeaderboardApp() throws SQLException {
        super("Profile");
        showProfile();
    }
    public void makePanel() throws SQLException {

        JLabel tittle = new JLabel("Leaderboard");
        tittle.setHorizontalTextPosition(JLabel.CENTER);
        tittle.setFont(new Font("Poppins", Font.BOLD, 20));
        tittle.setPreferredSize(new Dimension(260, 35));
        tittle.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        tittle.setForeground(Color.decode("#e2b714"));

        JLabel gap = new JLabel();
        gap.setPreferredSize(new Dimension(260, 5));
        JLabel gap2 = new JLabel();
        gap2.setPreferredSize(new Dimension(260, 5));

        add(gap2);
        add(tittle);
        add(gap);

        JPanel userPanel = new JPanel();
//        userPanel.setPreferredSize(new Dimension(260, 260));
        userPanel.setBackground(Color.decode("#323437"));
//        userPanel.set
//        userPanel.setOpaque(false);
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
//        add(userPanel);

        JScrollPane scrollPane = new JScrollPane(userPanel);
        scrollPane.setPreferredSize(new Dimension(260, 260));
        scrollPane.setBackground(Color.decode("#323437"));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#323437"));
        scrollPane.getVerticalScrollBar().setForeground(Color.decode("#e2b714"));
        scrollPane.getVerticalScrollBar().setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        add(scrollPane);

        for (int i = 0; i <Score.usernames.size(); i++) {
//            JLabel nameLabel = new JLabel(Score.usernames.get(i));
            JLabel nameLabel = new JLabel(Score.usernames.get(i));
            nameLabel.setBorder(new MatteBorder(2, 0, 4, 0, Color.decode("#323437")));
//            nameLabel.setMaximumSize(new Dimension(260, 15));
            nameLabel.setFont(new Font("Poppins", Font.BOLD, 12));
            nameLabel.setForeground(Color.decode("#e2b714"));

            JLabel gap3 = new JLabel();
            gap.setMaximumSize(new Dimension(0, 5));
            JLabel gap4 = new JLabel();
            gap.setMaximumSize(new Dimension(0, 5));

//            JLabel usernameLabel = new JLabel(""+Score.highscores.get(i)+"");
            JLabel usernameLabel = new JLabel(""+Score.highscores.get(i)+"");
            usernameLabel.setForeground(Color.decode("#e2b714"));
            usernameLabel.setMaximumSize(new Dimension(240, 25));
            usernameLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
            usernameLabel.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));
            usernameLabel.setBackground(Color.decode("#212224"));
            usernameLabel.setOpaque(true);
            userPanel.add(nameLabel);
            userPanel.add(gap3);
            userPanel.add(usernameLabel);
            userPanel.add(gap4);
        }














    }
    public void showProfile() throws SQLException {
        makePanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#323437"));
        ImageIcon icon = new ImageIcon("assets/icon.png");
        Image image = icon.getImage();
        setSize(new Dimension(400, 400));
        setIconImage(image);
        setLayout(new FlowLayout(FlowLayout.LEFT, 60, 10));
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
