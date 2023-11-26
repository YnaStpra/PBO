package gui;

import api.Login;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginApp extends JFrame {

    JPanel panel;

    public LoginApp() {
        super("Login");

    }

    public void makePanel() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.decode("#323437"));


        JLabel tittle = new JLabel("Login");
        tittle.setFont(new Font("Poppins", Font.BOLD, 25));
        tittle.setPreferredSize(new Dimension(300, 30));
        tittle.setForeground(Color.decode("#e2b714"));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        panel.add(tittle);

        JLabel desc = new JLabel("Please, enter your detail");
        desc.setPreferredSize(new Dimension(300, 30));
        desc.setFont(new Font("Poppins", Font.BOLD, 14));
        desc.setForeground(Color.WHITE);
        panel.add(desc);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setPreferredSize(new Dimension(300, 35));
        usernameLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        usernameLabel.setForeground(Color.decode("#e2b714"));
        panel.add(usernameLabel);

        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(300, 30));
        username.setBackground(Color.decode("#212224"));
        username.setForeground(Color.decode("#e2b714"));
        username.setFont(new Font("Poppins", Font.PLAIN, 12));
        username.setCaretColor(Color.decode("#e2b714"));
        username.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));
        panel.add(username);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(300, 35));
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        passwordLabel.setForeground(Color.decode("#e2b714"));
        panel.add(passwordLabel);

        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(300, 30));
        password.setBackground(Color.decode("#212224"));
        password.setForeground(Color.decode("#e2b714"));
        password.setFont(new Font("Poppins", Font.PLAIN, 12));
        password.setCaretColor(Color.decode("#e2b714"));
        password.setBorder(new MatteBorder(0, 10, 0, 10, Color.decode("#212224")));

        panel.add(password);

        JPanel gap = new JPanel();
        gap.setBackground(Color.decode("#323437"));
        gap.setPreferredSize(new Dimension(300, 25));
        panel.add(gap);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(300, 40));
        loginButton.setBackground(Color.decode("#e2b714"));
        loginButton.setFont(new Font("Poppins", Font.BOLD, 16));
        loginButton.setForeground(Color.decode("#323437"));
        loginButton.setBorder(null);
        panel.add(loginButton);

        JPanel bottomDetail = new JPanel();
        bottomDetail.setBackground(null);
        bottomDetail.setPreferredSize(new Dimension(300, 30));
        bottomDetail.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

        JLabel asking = new JLabel("not have an account?");
        asking.setFont(new Font("Poppins", Font.PLAIN, 10));
        asking.setForeground(Color.WHITE);

        JButton registerButton = new JButton("register here");
        registerButton.setFont(new Font("Poppins", Font.BOLD, 10));
        registerButton.setForeground(Color.decode("#e2b714"));
        registerButton.setBackground(null);
        registerButton.setBorderPainted(false);

        bottomDetail.add(asking);
        bottomDetail.add(registerButton);

        panel.add(bottomDetail);

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 65));
        add(panel);

        loginButton.addActionListener(e -> {
            String usernameInput = username.getText();
            String passwordInput = new String (password.getPassword());
            try {
                Login.login(usernameInput, passwordInput);
                if (Login.isLogin){
                    dispose();
                    TypingApp typing = new TypingApp();
                    typing.showTypingApp();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        username.addActionListener(ActionEvent -> {
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            try {
                Login.login(usernameInput, passwordInput);
                if (Login.isLogin){
                    dispose();
                    TypingApp typing = new TypingApp();
                    typing.showTypingApp();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        password.addActionListener(ActionEvent -> {
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            try {
                Login.login(usernameInput, passwordInput);
                if (Login.isLogin){
                    dispose();
                    TypingApp typing = new TypingApp();
                    typing.showTypingApp();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        registerButton.addActionListener(e -> {
            RegisterApp register = new RegisterApp();
            register.showRegister();
            dispose();
        });

    }

    public void showLogin() {
        makePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#323437"));
        ImageIcon icon = new ImageIcon("assets/icon.png");
        Image image = icon.getImage();

        setIconImage(image);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
