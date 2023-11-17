import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class People extends JButton {
    String Name ;
    String Path = "E:/Kuliah/Praktikum/Semester 5/Pemrograman Berorientasi Objek/Praktikum/Modul 3/src/Image/people.png";

    String Number;
    List<Message> Messages = new ArrayList<>();
    People(String Name, String Path){
        this.Name = Name;
        this.Path = Path;

        Messages.add(new Message("P", this.Name));
        Messages.add(new Message("P", this.Name));
        Messages.add(new Message("Dimana", this.Name));
        Messages.add(new Message("Ayo Epic Bang", this.Name));

        ImageIcon newIcon = new ImageIcon(Path);
        JLabel newLabel = new JLabel(Name, newIcon, JLabel.LEFT);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(newLabel);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(320, 85));

    }
    People(String Name){
        this.Name = Name;
        Messages.add(new Message("P", this.Name));

        ImageIcon newIcon = new ImageIcon(Path);
        JLabel newLabel = new JLabel("   "+Name, newIcon, JLabel.LEFT);
        newLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        newLabel.setForeground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(newLabel);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#202c33"));

        setBackground(Color.decode("#111b21"));

        setBorder(border);
        setPreferredSize(new Dimension(325, 70));
    }
    public void showPeople(){

    }

    public String getName(){
        return Name;
    }
    public void setButtonBackground(Color color){
        setBackground(color);
    }



}
