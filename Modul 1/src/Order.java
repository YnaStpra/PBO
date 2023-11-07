public class Order {
    private Barang barang;
    private int amount;
    Order(Barang barang, int amount){
        this.barang=barang;
        this.amount=amount;
    }

    int getTotalPrice(){
        int total = barang.getPrice()*amount;
        return total;
    }
    public Barang getBarang(){
        return barang;
    }
    public int getAmount(){
        return amount;
    }
    void printNota(){
        System.out.println(barang.getName());
    }
}
