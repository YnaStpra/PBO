import java.util.ArrayList;

public class User {
    private String name;
    private double saldo;
    ArrayList<Order>order = new ArrayList<Order>();

    User(String name){
        this.name=name;
    }
    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void isiSaldo(double jumlah){
        saldo+=jumlah;
        if (jumlah>=50000){
            System.out.println(getName()+" Saldo berhasil diisi sebesar Rp"+ jumlah );
        }else{
            System.out.println(getName()+" Pengisian saldo gagal. Jumlah minimal pengisian saldo adalah Rp50,000 " );
        }
    }
    public void minSaldo(double jumlah){

        if (jumlah<=saldo){
            saldo-=jumlah;
            System.out.println("Sisa saldo: Rp"+saldo);
        }else{
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
        }
    }
    public double getSaldo(){
        return saldo;
    }
    void addToOrder(Barang product, int amount){
        Order order1 = new Order(product,amount);
        order.add(order1);
    }
    void payOrder(Bank bank){
        System.out.println("Nota "+getName());
        System.out.println("Bank Di gunakan: "+bank.getName());
        if (bank.isActive()){

        System.out.println("Diskon bank: "+bank.getBankDiscount()+"%");

            for(int i=0;i<order.size();i++){
                int dis=order.get(i).getTotalPrice()*bank.getBankDiscount()/100;
                System.out.println(order.get(i).getBarang().getName()+" x "+order.get(i).getAmount()+" = Rp"+ order.get(i).getTotalPrice());
                System.out.println("Total belanja sebelum diskon: Rp"+order.get(i).getTotalPrice());
                System.out.println("Total belanja setelah diskon: Rp" + (order.get(i).getTotalPrice()-dis));
                minSaldo(order.get(i).getTotalPrice()-dis);
                if (getSaldo()>order.get(i).getTotalPrice()-dis){

                order.get(i).getBarang().reduceStock(order.get(i).getAmount());
                }
            }
        }else{
            System.out.println("Pembayaran tidak dapat diproses karena bank tidak aktif");
        }
            System.out.println();

    }
}
