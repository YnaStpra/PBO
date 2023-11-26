package tools;

public class WPMCalculate {
    public static int calculateWPM(int totalWords, double totalSeconds){
        return (int) Math.round((double) totalWords/(totalSeconds / 60));
    }

}
