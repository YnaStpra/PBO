public class Baju extends Barang{
    private String size;
    public Baju(String name, int price, String size){
        super(name,price);
        this.size=size;
    }
    public String getSize(){
        return size;
    }
    public void setStock(int stock){
        super.setStock(stock);
    }
    public void reduceStock(int amount){
        super.reduceStock(amount);
        System.out.println("Reduced Baju by "+amount);
    }
}
