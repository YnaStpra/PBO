package gui;

import javax.swing.*;

public class TimerLabel extends JLabel implements Runnable {
    private int seconds;
    private int minutes;

    public static boolean isTimesUp = false;

    public static int secondCounter = 0;
    private Thread t = new Thread(this);
    TimerLabel(){
        super("01:00");
    }

    public void start(){
        isTimesUp = false;
        secondCounter = 0;
        t.start();
    }
    @Override
    public void run() {
        seconds = 20;
        while (true) {
            try {
                Thread.sleep(1000);
                seconds--;
                secondCounter++;
                System.out.println(secondCounter+" detik");
                minutes = seconds / 60;
                String time = String.format("%02d:%02d", getMinutes(), getSeconds()%60);
                setText(time);
                if (seconds == 0) {
                    reset();
                    isTimesUp = true;
                    setText("Time's up!");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("berhenti ni");
                break;
            }
        }
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    public int getMinutes(){
        return minutes;
    }
    public void reset(){
//        setUnrun();
        t.interrupt();
        isTimesUp = false;
        t= new Thread(this);
        seconds = 60;
//        secondCounter = 0;
        setText("01:00");
//        t.start();
    }

}
