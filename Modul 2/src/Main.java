public class Main {
    public static void main(String[] args) {
        Monster monster = new Monster("Sally", 80, 20, 10);
        Alien alien = new Alien("Zograd", 80, 20, 10);

        monster.showEntityInfo();
        alien.showEntityInfo();

        monster.attack(alien);



    }

}