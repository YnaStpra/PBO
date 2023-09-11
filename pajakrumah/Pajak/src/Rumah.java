class Rumah {
    private String tipe;
    private double harga;

    public Rumah(String tipe, double harga) {
        this.tipe = tipe;
        this.harga = harga;
    }

    public double hitungPBB() {
        if (tipe.equals("Tipe 36")) {
            return harga * 0.04;
        } else if (tipe.equals("Tipe 45")) {
            return harga * 0.06;
        } else {
            return harga * 0.09;
        }
    }
}