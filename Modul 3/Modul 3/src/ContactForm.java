import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContactForm extends JFrame {
    private static List<People> peopleList;
    ContactForm(List<People> newpeopleList){
        peopleList = newpeopleList;
        Border border = BorderFactory.createMatteBorder(0, 6, 0, 6, Color.decode("#202c33"));

        JPanel panelName = new JPanel();
        panelName.setBackground(Color.decode("#111b21"));
        panelName.setLayout(new BorderLayout());
        panelName.setPreferredSize(new Dimension(350, 30));
        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Poppins", Font.BOLD, 12));
        labelName.setForeground(Color.WHITE);
        labelName.setVerticalTextPosition(JLabel.BOTTOM);
        JTextField textFieldName = new JTextField("Input Name");
        textFieldName.setPreferredSize(new Dimension(280, 25));
        textFieldName.setBackground(Color.decode("#202c33"));
        textFieldName.setForeground(Color.decode("#85959f"));
        textFieldName.setBorder(border);
        textFieldName.setCaretColor(Color.WHITE);
        textFieldName.setFont(new Font("Poppins", Font.BOLD, 12));
        panelName.add(labelName, BorderLayout.WEST);
        panelName.add(textFieldName, BorderLayout.EAST);

        JPanel panelNumber = new JPanel();
        panelNumber.setBackground(Color.decode("#111b21"));
        panelNumber.setLayout(new BorderLayout());
        panelNumber.setPreferredSize(new Dimension(350, 30));
        JLabel labelNumber = new JLabel("Number");
        labelNumber.setFont(new Font("Poppins", Font.BOLD, 12));
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setVerticalTextPosition(JLabel.BOTTOM);
        JTextField textFieldNumber = new JTextField("Input Number");
        textFieldNumber.setPreferredSize(new Dimension(280, 25));
        textFieldNumber.setBackground(Color.decode("#202c33"));
        textFieldNumber.setForeground(Color.decode("#85959f"));
        textFieldNumber.setBorder(border);
        textFieldNumber.setCaretColor(Color.WHITE);
        textFieldNumber.setFont(new Font("Poppins", Font.BOLD, 12));
        panelNumber.add(labelNumber, BorderLayout.WEST);
        panelNumber.add(textFieldNumber, BorderLayout.EAST);


        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.decode("#111b21"));
        ImageIcon imageIcon = new ImageIcon("E:/Kuliah/Praktikum/Semester 5/Pemrograman Berorientasi Objek/Praktikum/Modul 3/src/Image/imageIcon.png");
//
        JButton addImageButton = new JButton(imageIcon);
        addImageButton.setPreferredSize(new Dimension(35,35));
        addImageButton.setBackground(Color.decode("#00a884"));
        addImageButton.setBorder(null);
        JButton addContactButton = new JButton("Add Contact");
        addContactButton.setBackground(Color.decode("#00a884"));
        addContactButton.setFont(new Font("Poppins", Font.BOLD, 12));;
        addContactButton.setPreferredSize(new Dimension(310,35));
        addContactButton.setBorder(null);

        addImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Jika file/direktori dipilih
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                } else {
                    // Jika operasi dibatalkan atau di-close
                    System.out.println("File selection canceled.");
                }
            }
        });

        JPanel panel = new JPanel();

        actionPanel.add(addContactButton);
        actionPanel.add(addImageButton);

        JList<String> list = new JList<>(ContactList.getPeopleName().toArray(new String[0]));
//        list.setPreferredSize(new Dimension(350, 300));
        list.setBackground(Color.decode("#202c33"));
        list.setFont(new Font("Poppins", Font.PLAIN, 12));
        list.setBorder(new LineBorder(Color.decode("#202c33"), 12));
        list.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#202c33"));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8,0));
        scrollPane.setBorder(null);

        JLabel labelContact = new JLabel("Your Contact");
        labelContact.setFont(new Font("Poppins", Font.BOLD, 12));
        labelContact.setForeground(Color.WHITE);

        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peopleList.add(new People(textFieldName.getText()));
                ContactList.setPeopleList(getPeopleList());
                ContactBox.update();
                list.setListData(ContactList.getPeopleName().toArray(new String[0]));
                list.revalidate();
            }
        });
        panel.setBackground(Color.decode("#111b21"));
        panel.add(panelName);
        panel.add(panelNumber);
        panel.add(actionPanel);
        panel.add(labelContact);
        panel.add(scrollPane);

        add(panel);
        setTitle("Contact Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void setPeopleList(List<People> newpeopleList){
        peopleList = newpeopleList;
    }
    public static List<People> getPeopleList(){
        return peopleList;
    }
}
