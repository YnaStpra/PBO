package gui;

import api.Score;
import tools.WPMCalculate;

import javax.swing.*;
import java.sql.SQLException;

public class ScoreLabel extends JLabel implements Runnable{

    public static int score;
    private Thread t = new Thread(this);

    public ScoreLabel(){
        super("Score: 0 WPM");
    }

    public void start(){
        score = 0;
        setText("Score: 0 WPM");
        t.start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("score : "+score+" dengan detik : "+TimerLabel.secondCounter);
                score = WPMCalculate.calculateWPM(WordGeneratePanel.correctWord, TimerLabel.secondCounter);
                setText("Score: " + score + " WPM" );
                System.out.println(score + " WPM");
                if (TimerLabel.isTimesUp) {

                    reset();
//                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("berhenti ni");
                break;
            }
        }
//        seconds = 60;
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                seconds--;
//                minutes = seconds / 60;
//                String time = String.format("%02d:%02d", getMinutes(), getSeconds()%60);
//                setText(time);
//                if (seconds == 0) {
//                    break;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("berhenti ni");
//                break;
//            }
//        }
    }
    public void reset(){
//        setUnrun();
        t.interrupt();
        t= new Thread(this);

//        t.start();
    }
}
