package DTO;
/**
 *
 * @author Hp
 */
public class AirConditioner extends Product{
    private String power;

    public AirConditioner(String power, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.power = power;
    }    

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }        

    @Override
    public void showDetail() {
        String msg;
        msg = String.format("|%6s|%-30s|%-25s|%5s|%10.4f|%8d|"
                        , code, name, brand, power, price, quantity);
        System.out.println(msg);
    }

    @Override
    public double totalAmount() {
        return price * quantity;
    }
    
}
