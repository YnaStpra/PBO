package gui;

import api.Dataset;
import api.Score;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class WordGeneratePanel extends JPanel implements Runnable{

    public static int correctWord;
    private Thread t = new Thread(this);

    public WordGeneratePanel(){
        super();



        setPreferredSize(new Dimension(695, 100));
        setBackground(Color.decode("#212224"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        init();

    }
    public void start(){
        correctWord = 0;
        t.start();
    }


    public void init(){
        for (int i = 0; i < 10; i++) {
            addWord(Dataset.data.get(Dataset.randomIndex()));
        }
    }
    public void addWord(String word){
        JLabel wordButton = new JLabel(word);
        wordButton.setBackground(Color.decode("#323437"));
        wordButton.setForeground(Color.decode("#e2b714"));
        wordButton.setFont(new Font("Poppins", Font.BOLD, 25));
        wordButton.setBorder(null);
        add(wordButton);
    }
    public void correctWord(JLabel wordButton){
        wordButton.setForeground(Color.GREEN);
        wordButton.setOpaque(false);
        correctWord++;
    }
    public void wrongWord(JLabel wordButton){
        wordButton.setForeground(Color.RED);
        wordButton.setOpaque(false);
    }
    public void currentWord(JLabel wordButton){
        wordButton.setForeground(Color.decode("#212224"));
        wordButton.setBackground(Color.decode("#e2b714"));
        wordButton.setOpaque(true);
    }

    public void reset(){
        correctWord = 0;
        t.interrupt();
        t = new Thread(this);
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                if (TimerLabel.isTimesUp){

                    Score.updateScore(ScoreLabel.score);
                    System.out.println("reset");
                    reset();
                    removeAll();
                    init();
                    TypingApp.wordCount = 0;
                    correctWord=0;
                    currentWord((JLabel) getComponent(TypingApp.wordCount));
                    revalidate();
                    repaint();
                    t.interrupt();
                    t = new Thread(this);
                    requestFocusInWindow();
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
