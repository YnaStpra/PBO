public abstract class Entity {
    protected String name;
    protected int health;
    protected int attack;
    protected int defence;
    protected static int count;

    public Entity(String name, int health, int attack, int defence) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        count++;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void showEntity();
}





