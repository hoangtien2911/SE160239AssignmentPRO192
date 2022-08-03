
package DTO;

/**
 *
 * @author Hp
 */
public abstract class Product {
    protected String code;
    protected String name;
    protected String brand;
    protected double price;
    protected int quantity;

    public Product(String code, String name, String brand, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }    
    
    public abstract void showDetail();
    public abstract double totalAmount();
}
