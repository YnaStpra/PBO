package gui;

import api.Profile;
import api.Score;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

public class ProfileApp extends JFrame {
    private String username;
    private Integer[] score;
    private int jum_tes;

    private int highscored;

    public ProfileApp() throws SQLException {
        super("Profile");
        showProfile();
    }
    public void makePanel() throws SQLException {
        Score.getUserScore();
        username = Profile.getUsername();
        score = Score.getScore();
        highscored = Score.getHighScore();
        if (score == null){
            jum_tes = 0;
        }else{
            jum_tes = score.length;
        }

        JLabel tittle = new JLabel("Profil");
        tittle.setHorizontalTextPosition(JLabel.CENTER);
        tittle.setFont(new Font("Poppins", Font.BOLD, 20));
        tittle.setPreferredSize(new Dimension(260, 35));
        tittle.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        tittle.setForeground(Color.decode("#e2b714"));

        JLabel gap = new JLabel();
        gap.setPreferredSize(new Dimension(260, 5));
        JLabel gap2 = new JLabel();
        gap2.setPreferredSize(new Dimension(260, 5));

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setPreferredSize(new Dimension(300, 15));
        nameLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        nameLabel.setForeground(Color.decode("#e2b714"));

        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setOpaque(true);
        usernameLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
        usernameLabel.setPreferredSize(new Dimension(260, 25));
        usernameLabel.setForeground(Color.decode("#e2b714"));
        usernameLabel.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));
        usernameLabel.setBackground(Color.decode("#212224"));

        JLabel highscoreLabel = new JLabel("Highscore");
        highscoreLabel.setPreferredSize(new Dimension(300, 15));
        highscoreLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        highscoreLabel.setForeground(Color.decode("#e2b714"));

        JLabel highscore = new JLabel(""+highscored+"");
        highscore.setPreferredSize(new Dimension(260, 25));
        highscore.setFont(new Font("Poppins", Font.PLAIN, 12));
        highscore.setForeground(Color.decode("#e2b714"));
        highscore.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));
        highscore.setBackground(Color.decode("#212224"));
        highscore.setOpaque(true);

        JLabel attempLabel = new JLabel("Jumlah Tes");
        attempLabel.setPreferredSize(new Dimension(300, 15));
        attempLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        attempLabel.setForeground(Color.decode("#e2b714"));

        JLabel attemp = new JLabel(""+jum_tes+"");
        attemp.setPreferredSize(new Dimension(260, 25));
        attemp.setForeground(Color.decode("#e2b714"));
        attemp.setFont(new Font("Poppins", Font.PLAIN, 12));
        attemp.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));
        attemp.setBackground(Color.decode("#212224"));
        attemp.setOpaque(true);

        add(gap2);
        add(tittle);
        add(gap);
        add(nameLabel);
        add(usernameLabel);
        add(highscoreLabel);
        add(highscore);
        add(attempLabel);
        add(attemp);




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
