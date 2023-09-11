import java.util.Random;
import java.util.Scanner;

public class BatuGuntingKertas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] pilihan = { "Batu", "Gunting", "Kertas" };

        System.out.println("Selamat datang di permainan Batu, Gunting, Kertas!");
        System.out.println("Pilihan Anda: 0 - Batu, 1 - Gunting, 2 - Kertas");

        while (true) {
            System.out.print("Pilihan Anda (0/1/2): ");
            int pilihanPemain = input.nextInt();

            if (pilihanPemain < 0 || pilihanPemain > 2) {
                System.out.println("Pilihan tidak valid. Silakan pilih 0, 1, atau 2.");
                continue;
            }

            int pilihanKomputer = random.nextInt(3);

            System.out.println("Anda memilih: " + pilihan[pilihanPemain]);
            System.out.println("Komputer memilih: " + pilihan[pilihanKomputer]);

            int hasil = (3 + pilihanPemain - pilihanKomputer) % 3;

            if (hasil == 0) {
                System.out.println("Hasil: Seri!");
            } else if (hasil == 1) {
                System.out.println("Hasil: Anda Menang!");
            } else {
                System.out.println("Hasil: Komputer Menang!");
            }

            System.out.print("Apakah Anda ingin bermain lagi? (y/tidak): ");
            String jawaban = input.next().toLowerCase();

            if (!jawaban.equals("y")) {
                break;
            }
        }

        System.out.println("Terima kasih telah bermain!");
        input.close();
    }
}
