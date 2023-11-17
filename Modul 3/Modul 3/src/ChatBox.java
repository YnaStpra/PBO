import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class ChatBox extends JPanel {
    static private People people ;
    static private JLabel peopleName = new JLabel();
    static private Messages messages = new Messages();

    ChatBox(){
        setBackground(Color.decode("#0f0c0c"));
        setPreferredSize(new Dimension(620, 600));

        peopleName.setForeground(Color.WHITE);
        peopleName.setBackground(Color.decode("#202c33"));
        peopleName.setOpaque(true);
        peopleName.setText(people.getName());
        peopleName.setPreferredSize(new Dimension(620, 50));
        peopleName.setHorizontalAlignment(JLabel.CENTER);
        peopleName.setFont(new Font("Poppins", Font.BOLD, 18));
        add(peopleName);
        add(messages);

        JScrollPane scrollPane = new JScrollPane(messages);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 430));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#0f0c0c"));
//        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#0f0c0c"));
        scrollPane.getVerticalScrollBar().setBorder(null);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);
            }
        });
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        add(scrollPane);

        JPanel sendPanel = new JPanel();
        sendPanel.setBackground(Color.decode("#202c33"));
        sendPanel.setBorder(null);
        sendPanel.setLayout(new FlowLayout());
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(550, 32));
        textField.setFont(new Font("Poppins", Font.PLAIN, 12));
        Border border = BorderFactory.createMatteBorder(0, 6, 0, 6, Color.decode("#2a3942"));
        textField.setBorder(border);
        textField.setBackground(Color.decode("#2a3942"));
        textField.setForeground(Color.decode("#8696a0"));
        textField.setCaretColor(Color.WHITE);

        ImageIcon icon = new ImageIcon("E:/Kuliah/Praktikum/Semester 5/Pemrograman Berorientasi Objek/Praktikum/Modul 3/src/Image/send1.png");
        JButton sendButton = new JButton(icon);
        sendButton.setBackground(Color.decode("#00a884"));
        sendButton.setBorder(null);
        sendButton.setPreferredSize(new Dimension(32, 32));
        sendButton.setFont(new Font("Poppins", Font.PLAIN, 10));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()){
                    people.Messages.add(new Message(textField.getText(), "You"));
                    update();
                    textField.setText("");
                    scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                        public void adjustmentValueChanged(AdjustmentEvent e) {
                            e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                            scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);
                        }
                    });

//
                }
            }
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==KeyEvent.VK_ENTER){
                    if (!textField.getText().isEmpty()){
                        people.Messages.add(new Message(textField.getText(), "You"));
                        update();
                        textField.setText("");
                        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                            public void adjustmentValueChanged(AdjustmentEvent e) {
                                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                                scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);}
                        });
                    }
                }
            }
        });

        sendPanel.add(textField);
        sendPanel.add(sendButton);
        add(sendPanel);
    }
    public static void setPeople(People newPeople){
        people = newPeople;
        update();
    }
    public static void update(){
        peopleName.setText(people.getName());
        messages.removeAll();
        messages.setPeople(people);
        messages.revalidate();
        messages.repaint();
    }



}
