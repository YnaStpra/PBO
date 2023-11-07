public class Monster extends Entity implements Behaviour {
    int count = 0;
    Alien alien;
    public Monster(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    public void attack (Alien alien){
        System.out.println();
        if (alien.health != 0 && this.health != 0){
            attackAlien(alien);
            alien.attackMonster(this);
            if (alien.health <= 0){
                System.out.println("The Monster " + this.name + " wins");
                return;
            }
            if (this.health <= 0){
                System.out.println("The Alien " + alien.name + " wins");
                dead();
                return;

            }
            attack(alien);
        }
    }

    public void attackAlien (Entity alien) {
        System.out.println();
        if (count != 3) {
            count ++;
            if (count == 3) {
                spesialSkill(alien);
                count = 0;
            }
            else {
            System.out.println("The Monster " + alien.name + " attacks " + this.name + " with a normal attack");
            alien.health = alien.health - (this.attack - alien.defense);

            System.out.println(this.name + " | " + this.health);
            System.out.println(alien.name + " | " + alien.health);}
        }

    }

        @Override
        void showEntityInfo() {
            System.out.println("Monster : " + this.name + " | " + "Health : " + this.health + " | " + "Attack : " + this.attack + " | " + "Defense : " + this.defense);
        }

        @Override
        public void dead() {
            if (this.health <= 0){
                System.out.println("The Monster " + this.name + " is dead");
            }
        }

        @Override
        public void spesialSkill(Entity monster) {
            System.out.println( "The monster use special skill");
            this.health = this.health + (this.health/2);

            System.out.println(this.name + " | " + this.health);
            System.out.println(monster.name + " | " + monster.health);

        }


}
