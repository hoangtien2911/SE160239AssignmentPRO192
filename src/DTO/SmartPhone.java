
package DTO;

/**
 *
 * @author Hp
 */
public class SmartPhone extends Product{
    private String ram;
    private String cpu;
    private String size;

    public SmartPhone(String ram, String cpu, String size, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.ram = ram;
        this.cpu = cpu;
        this.size = size;
    }    

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
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
        msg = String.format("|%6s|%-30s|%-25s|%-10s|%-16s|%-14s|%10.4f|%8d|"
                        , code, name, brand, ram, cpu, size, price, quantity);
        System.out.println(msg);
    }

    @Override
    public double totalAmount() {
        return price * quantity;
    }
    
}
