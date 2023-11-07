
public class Main {
    public static void main(String[] args) {
        Alien zorg = new Alien("Zorg", 100, 20, 10);
        Monster gorg = new Monster("Gorg", 80, 25, 15);

        zorg.showEntity();
        gorg.showEntity();

        System.out.println("Pertarungan dimulai!");
        while (zorg.health > 0 && gorg.health > 0) {
            //Zorg menyerang gorg
            System.out.println(zorg.name + " menyerang " + gorg.name);
            gorg.health -= zorg.attack - gorg.defence;
            if (gorg.health <= 0) {
                gorg.dead();
                break;
            }

            System.out.println(gorg.name + " menyerang " + zorg.name);
            zorg.health -= gorg.attack - zorg.defence;
            if (zorg.health <= 0) {
                zorg.dead();
                break;
            }

            System.out.println(zorg.name + " dan " + gorg.name + " menggunakan skill khusus");
            zorg.specialSkill();
            gorg.specialSkill();
        }
        System.out.println("Pertarungan berakhir!");
    }
}
