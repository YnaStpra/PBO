import javax.swing.*;
import java.awt.*;

public class SnakeGameGUI extends JFrame {
    public SnakeGameGUI() {
        initUI();
    }

    private void initUI() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        SnakeBoard board = new SnakeBoard();
        add(board);

        pack();

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ex = new SnakeGameGUI();
            ex.setVisible(true);
        });
    }
}

class SnakeBoard extends JPanel {
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;

    public SnakeBoard() {
        initBoard();
    }

    private void initBoard() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSnake(g);
    }

    private void drawSnake(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, 10, 10); // Draw the snake (just a simple green square for now)
    }
}
