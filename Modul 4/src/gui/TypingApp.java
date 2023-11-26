package gui;

import api.Dataset;
import api.Score;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class TypingApp extends JFrame{
    public static int wordCount = 0;
    private boolean isThreadExecuted = false;
    public TypingApp(){
        super("Typing");
    }
    public void makePanel(){
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(700, 30));
        topPanel.setBackground(null);
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JButton leaderButton = new JButton();
        leaderButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        leaderButton.setBorder(null);
        leaderButton.setBackground(null);
        JLabel leaderLabel = new JLabel(new ImageIcon("assets/leaderboard.png"));
        leaderLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
        leaderButton.add(leaderLabel);
        JLabel leaderText = new JLabel("leaderboard");
        leaderText.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        leaderText.setForeground(Color.decode("#e2b714"));
        leaderButton.add(leaderText);
        leaderButton.addActionListener(e -> {
            try {
                Score.getUserScore();
                LeaderboardApp leaderboardApp = new LeaderboardApp();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


        JButton profileButton = new JButton();
        profileButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        profileButton.setBorder(null);
        profileButton.setBackground(null);
        JLabel profileLabel = new JLabel(new ImageIcon("assets/profile.png"));
        profileLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
        profileButton.add(profileLabel);
        JLabel profileText = new JLabel("profile");
        profileText.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        profileText.setForeground(Color.decode("#e2b714"));
        profileButton.add(profileText);

        profileButton.addActionListener(e -> {
            try {
                ProfileApp profileApp = new ProfileApp();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        topPanel.add(leaderButton);
        topPanel.add(profileButton);


        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout());
        scorePanel.setPreferredSize(new Dimension(700, 100));

        ScoreLabel scoreLabel = new ScoreLabel();
        scoreLabel.setForeground(Color.decode("#e2b714"));

        scoreLabel.setVerticalAlignment(JLabel.BOTTOM);
        scoreLabel.setFont(new Font("Poppins", Font.BOLD, 16));

        TimerLabel timeLabel = new TimerLabel();
        timeLabel.setForeground(Color.decode("#e2b714"));
        timeLabel.setVerticalAlignment(JLabel.BOTTOM);
        timeLabel.setFont(new Font("Poppins", Font.BOLD, 16));

        scorePanel.add(scoreLabel, BorderLayout.WEST);
        scorePanel.add(timeLabel, BorderLayout.EAST);
        scorePanel.setBackground(null);

        WordGeneratePanel wordContainer = new WordGeneratePanel();
        wordContainer.currentWord((JLabel) wordContainer.getComponent(0));
        


        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(700, 100));
        inputPanel.setBackground(null);
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JTextField inputField = new JTextField();
        inputField.setCaretColor(Color.decode("#e2b714"));
        inputField.setPreferredSize(new Dimension(610, 50));
        inputField.setBackground(Color.decode("#212224"));
        inputField.setForeground(Color.decode("#e2b714"));
        inputField.setFont(new Font("Poppins", Font.BOLD, 16));
        inputField.setBorder(new MatteBorder(0, 20, 0, 20, Color.decode("#212224")));

        inputField.addMouseListener(new MouseAdapter() {



            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!isThreadExecuted){
                    System.out.println("clicked");
                    wordContainer.reset();
                    wordContainer.start();
                    scoreLabel.start();
                    timeLabel.start();
                    isThreadExecuted = true;
                }
                if (TimerLabel.isTimesUp){
                    isThreadExecuted = false;
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!isThreadExecuted){
                    System.out.println("clicked");
                    wordContainer.reset();
                    wordContainer.start();
                    scoreLabel.start();
                    timeLabel.start();
                    isThreadExecuted = true;
                }
                if (TimerLabel.isTimesUp){
                    isThreadExecuted = false;
                }
            }
        });

        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == KeyEvent.VK_SPACE){
                    String input = inputField.getText();
                    if(!input.equals("")){
                        if(wordCount >=4){
                            System.out.println();
                            for (int i = 0; i < 5; i++) {
                                wordContainer.remove(0);
                                wordContainer.addWord(Dataset.data.get(Dataset.randomIndex()));
                            }
                            wordCount = 0;
                        }else{
                            checkWord(wordContainer,
                                    input,
                                    (JLabel) wordContainer.getComponent(wordCount));
                            wordCount++;
                        }
                        wordContainer.currentWord((JLabel) wordContainer.getComponent(wordCount));
                        wordContainer.revalidate();
                        wordContainer.repaint();
                        inputField.setText("");
                    }
                }
            }
        });



        JButton restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(80, 50));
        restartButton.setBackground(Color.decode("#e2b714"));
        restartButton.setForeground(Color.BLACK);
        restartButton.setFont(new Font("Poppins", Font.BOLD, 16));
        restartButton.setBorder(null);

        restartButton.addActionListener(e -> {
            scoreLabel.reset();
            timeLabel.reset();
            wordContainer.reset();
            isThreadExecuted = false;
            wordContainer.removeAll();
            wordContainer.init();
            wordCount = 0;
            wordContainer.currentWord((JLabel) wordContainer.getComponent(wordCount));
        });

        inputPanel.add(inputField);
        inputPanel.add(restartButton);


        add(topPanel);
        add(scorePanel);
        add(wordContainer);
        add(inputPanel);
    }
    public void showTypingApp(){
        makePanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("assets/icon.png");
        Image image = icon.getImage();
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        setIconImage(image);
        getContentPane().setBackground(Color.decode("#323437"));
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void checkWord(WordGeneratePanel wordContainer, String input, JLabel wordComp ){
        input = input.trim();
        if(input.equals(wordComp.getText())){
            wordContainer.correctWord(wordComp);
        }else{
            wordContainer.wrongWord(wordComp);
        }
    }
}
