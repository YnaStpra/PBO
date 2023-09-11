class Ayah {
    private String nama;
    private Rumah rumah;

    public Ayah(String nama, Rumah rumah) {
        this.nama = nama;
        this.rumah = rumah;
    }

    public double hitungPBB() {
        return rumah.hitungPBB();
    }

    public String getNama() {
        return nama;
    }
}