public abstract class Entity {

    String name;
    int health = 80;
    int attack = 20;
    int defense = 10;

    public Entity(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void showEntityInfo();



}
