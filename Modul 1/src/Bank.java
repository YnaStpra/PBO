public class Bank extends User{
    private int id;
    private boolean active= true;
    private int bankDiscount = 0;

    public Bank(String name, int id){
        super(name);
        this.id=id;
    }

    public int getId(){
        return id;
    }
    public void setBankDiscount(int discount){
        this.bankDiscount = discount;
    }
    public int getBankDiscount(){
        return bankDiscount;
    }
    public void activate(){
        this.active=true;
    }
    public void deactivate(){
        this.active=false;
    }
    public boolean isActive(){
        return active==true;
    }
}
