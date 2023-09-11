public class BangunRuang {
    private double sisi;
    private double panjang;
    private double lebar;
    private double tinggi;
    private double jariJari;

    // Constructors

    public BangunRuang() {
        // Default constructor
    }

    public BangunRuang(double sisi) {
        this.sisi = sisi;
    }

    public BangunRuang(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Overloaded Constructor with a String parameter
    public BangunRuang(double jariJari, String bola) {
        this.jariJari = jariJari;
    }

    // Mutator and Accessor methods

    public double hitungLuasKubus() {
        return 6 * Math.pow(sisi, 2);
    }

    public double hitungLuasBalok() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    public double hitungLuasBola() {
        return 4 * Math.PI * Math.pow(jariJari, 2);
    }

    public double hitungVolumeKubus() {
        return Math.pow(sisi, 3);
    }

    public double hitungVolumeBalok() {
        return panjang * lebar * tinggi;
    }

    public double hitungVolumeBola() {
        return (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
    }
}
