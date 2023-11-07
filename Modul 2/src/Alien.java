public class Alien extends Entity implements Behavior {
    public Alien(String name, int health, int attack, int defence) {
        super(name, health, attack, defence);
    }

    @Override
    public void showEntity() {
        System.out.println("Nama: " + this.name);
        System.out.println("Health: " + this.health);
        System.out.println("Attack: " + this.attack);
        System.out.println("Defence: " + this.defence);
    }

    @Override
    public void dead() {
        System.out.println(this.name + " mati");
    }

    @Override
    public void specialSkill() {
        System.out.println(this.name + " menggunakan skill khusus");
    }
}