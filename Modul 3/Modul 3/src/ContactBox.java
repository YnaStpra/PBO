import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContactBox extends JPanel {

    JButton newChat = new JButton("New Chat");
    public static ContactList contactList = new ContactList();


    ContactBox(){
        showList();
    }
    public void showList(){
        setBackground(Color.decode("#111b21"));
        setBorder(null);
        setPreferredSize(new Dimension(350, 600));
        newChat.setPreferredSize(new Dimension(350, 30));
        newChat.setBackground(Color.decode("#00a884"));
        newChat.setBorder(null);
        newChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactForm contactForm = new ContactForm(ContactList.getPeopleList());

            }
        });
        this.add(newChat);
//        this.add(contactList);
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#111b21"));
        scrollPane.getVerticalScrollBar().setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(350, 510));
        scrollPane.setBorder(null);
        add(scrollPane);
    }
    public static void update(){
        contactList.removeAll();
        contactList.revalidate();
        contactList.repaint();
        contactList.showContactList();
    }
    public void setContactList(ContactList newContactList){
        contactList = newContactList;
//        update();
    }
}
