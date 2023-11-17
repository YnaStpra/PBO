import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ContactList extends JPanel {

    private static List<People> peopleList = new ArrayList<>();


    ContactList(){
        peopleList.add(new People("Galih Saputra"));
        ChatBox.setPeople(peopleList.get(0));
        peopleList.add(new People("Ramadhani"));
        peopleList.add(new People("Dhira Wahyu"));
        peopleList.add(new People("Risqi Duha"));
        peopleList.add(new People("Yan Saputra"));
        peopleList.add(new People("Hifric Aldar"));
        peopleList.add(new People("Dzulhi Raihan"));
        peopleList.add(new People("Fauzan Azima"));
        peopleList.add(new People("Ali An Nuur"));
        peopleList.add(new People("Dimas Nugraha"));


        showContactList();


        setBackground(Color.decode("#111b21"));
        setBorder(null);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
    public void showContactList(){
        for (int i = 0; i< peopleList.size(); i++){
            People person = peopleList.get(i);
            person.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    ChatBox.setPeople(person);
                }
            });
            person.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseClicked(e);
                    person.setButtonBackground(
                            new Color(
                                    person.getBackground().getRed() + 15,
                                    person.getBackground().getGreen() + 17,
                                    person.getBackground().getBlue() + 18
                            )
                    );
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    resetColor();
                    resetColor();
                    person.setButtonBackground(
                            new Color(
                                    person.getBackground().getRed() + 30,
                                    person.getBackground().getGreen() + 34,
                                    person.getBackground().getBlue() + 36
                            )
                    );
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    person.setButtonBackground(
                            new Color(
                                    person.getBackground().getRed() - 15,
                                    person.getBackground().getGreen() - 17,
                                    person.getBackground().getBlue() - 18
                            )
                    );
                }
            });
            add(peopleList.get(i));
        }

    }
    public static List<People> getPeopleList(){
        return peopleList;
    }
    public void update(){
        removeAll();
//        showContactList();
        revalidate();
        repaint();
    }

    public static List<String> getPeopleName(){
        List<String> peopleName = new ArrayList<>();
        for (int i = 0; i< peopleList.size(); i++){
            peopleName.add(peopleList.get(i).getName());
        }
        return peopleName;
    }
    public void resetColor(){
        for (int i = 0; i< peopleList.size(); i++){
            People person = peopleList.get(i);
            person.setButtonBackground(
                    Color.decode("#111b21")
            );
        }
    }
    public static void setPeopleList(List<People> newpeopleList){
        peopleList = newpeopleList;
    }
}
