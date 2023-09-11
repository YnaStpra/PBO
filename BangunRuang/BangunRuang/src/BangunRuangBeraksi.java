public class BangunRuangBeraksi {
    public static void main(String[] args) {
        BangunRuang kubus = new BangunRuang(7);
        BangunRuang balokDefault = new BangunRuang();
        BangunRuang balok = new BangunRuang(8, 6, 5);
        BangunRuang bola = new BangunRuang(7, "bola");

        System.out.println("Volume kubus dengan sisi 7 = " + kubus.hitungVolumeKubus());
        System.out.println("Luas kubus dengan sisi 7  = " + kubus.hitungLuasKubus());

        System.out.println("Volume balok dengan panjang default = " + balokDefault.hitungVolumeBalok());
        System.out.println("Luas balok dengan panjang default = " + balokDefault.hitungLuasBalok());

        System.out.println("Volume balok dengan panjang 10, lebar 5, dan tinggi 7 = " + balok.hitungVolumeBalok());
        System.out.println("Luas balok dengan panjang 10, lebar 5, dan tinggi 7 = " + balok.hitungLuasBalok());

        System.out.println("Volume bola dengan jari-jari 7 = " + bola.hitungVolumeBola());
        System.out.println("Luas bola dengan jari-jari 7 = " + bola.hitungLuasBola());
    }
}
