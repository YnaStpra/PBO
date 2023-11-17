import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ContactBox contactBox = new ContactBox();
        ChatBox chatBox = new ChatBox();


        JFrame frame = new JFrame("Aplikasi WhatsDown");
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#111b21"));
        panel.add(contactBox);
        panel.add(chatBox);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}