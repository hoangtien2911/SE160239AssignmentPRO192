package DTO;
/**
 *
 * @author Hp
 */
public class TV extends Product{
    private String size;

    public TV(String size, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.size = size;
    }        

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }    

    @Override
    public void showDetail() {
        String msg;
        msg = String.format("|%6s|%-30s|%-25s|%-14s|%10.4f|%8d|", code, name, brand
                                                         , size, price, quantity);
        System.out.println(msg);
    }

    @Override
    public double totalAmount() {
        return price * quantity;
    }    
}
