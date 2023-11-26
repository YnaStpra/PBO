import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SimpleChatApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Chat App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);

        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        JButton imageButton = new JButton("Send Image");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                chatArea.append("You: " + message + "\n");
                inputField.setText("");
            }
        });

        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menampilkan dialog pemilihan file
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Image files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Mendapatkan file gambar yang dipilih
                    File selectedFile = fileChooser.getSelectedFile();

                    // Menampilkan gambar di dalam JLabel
                    ImageIcon icon = new ImageIcon(selectedFile.getPath());
                    JLabel imageLabel = new JLabel(icon);
                    JOptionPane.showMessageDialog(frame, imageLabel, "Image Preview", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.WEST);
        inputPanel.add(imageButton, BorderLayout.EAST);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
