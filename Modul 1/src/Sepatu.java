public class Sepatu extends Barang{
    private int shoeSize;
    public Sepatu(String name, int price, int shoeSize){
        super(name,price);
        this.shoeSize=shoeSize;
    }
    public int getShoeSize(){
        return shoeSize;
    }
    public void setStock(int stock){
        super.setStock(stock);
    }
    public void reduceStock(int amount){
        super.reduceStock(amount);
        System.out.println("Reduced Sepatu by "+amount);
        System.out.println();
    }
}
