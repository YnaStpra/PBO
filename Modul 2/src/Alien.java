public class Alien extends Entity implements Behaviour{
    int count = 0;
    public Alien(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    public void attackMonster (Entity monster) {
        System.out.println();
        if (count != 4 ){
            count ++;
            if (count == 4) {
                spesialSkill(monster);
                count = 0;
            }
            else {
                System.out.println("The Alien " + this.name + " attacks " + monster.name + " with a normal attack");
                monster.health = monster.health - (this.attack - monster.defense);

                System.out.println(this.name + " | " + this.health);
                System.out.println(monster.name + " | " + monster.health);
            }
        }
    }

    @Override
    void showEntityInfo() {
        System.out.println("Alien : " + this.name + " | " + "Health : " + this.health + " | " + "Attack : " + this.attack + " | " + "Defense : " + this.defense);
    }

    @Override
    public void dead() {

    }

    @Override
    public void spesialSkill(Entity monster) {
        System.out.println( "The monster use special skill");
        monster.health = monster.health - (this.attack * 2);
        System.out.println(this.name + " | " + this.health);
        System.out.println(monster.name + " | " + monster.health);
    }



}
