public class Main {
    public static void main(String[] args) {
        // Membuat objek-objek rumah untuk Akbar, Bambang, dan Charlie
        Rumah rumahAkbar = new Rumah("Tipe 36", 1000000);
        Rumah rumahBambang = new Rumah("Tipe 45", 1500000);
        Rumah rumahCharlie = new Rumah("Tipe 90", 2000000);

        // Membuat objek-objek Ayah
        Ayah akbar = new Ayah("Akbar", rumahAkbar);
        Ayah bambang = new Ayah("Bambang", rumahBambang);
        Ayah charlie = new Ayah("Charlie", rumahCharlie);

        // Menghitung PBB untuk masing-masing Ayah
        double pbbAkbar = akbar.hitungPBB();
        double pbbBambang = bambang.hitungPBB();
        double pbbCharlie = charlie.hitungPBB();

        // Menampilkan hasil PBB untuk masing-masing Ayah
        System.out.println("PBB Akbar: Rp " + pbbAkbar);
        System.out.println("PBB Bambang: Rp " + pbbBambang);
        System.out.println("PBB Charlie: Rp " + pbbCharlie);
    }
}