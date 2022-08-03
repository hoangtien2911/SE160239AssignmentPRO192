
package DTO;

import MyUtils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Cabinet {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private ArrayList<Product> listProduct = new ArrayList<>();
    private ArrayList<SmartPhone> listSmartphone = new ArrayList<>();
    private ArrayList<TV> listTV = new ArrayList<>();
    private ArrayList<AirConditioner> listAirConditioner = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String headerSmartphone = String.format(ANSI_BLUE + "|%-6s|%-30s|%-25s|%-10s|%-16s|%-14s|%-10s|%8s|"
                        , "CODE", "NAME", "BRAND", "RAM", "CPU", "SIZE", "PRICE", "QUANTITY" + ANSI_RESET);
    private String headerTV = String.format(ANSI_BLUE + "|%-6s|%-30s|%-25s|%-14s|%-10s|%8s|"
                        , "CODE", "NAME", "BRAND", "SIZE", "PRICE", "QUANTITY" + ANSI_RESET);
    private String headerAirConditioner = String.format(ANSI_BLUE + "|%-6s|%-30s|%-25s|%5s|%-10s|%8s|"
                        , "CODE", "NAME", "BRAND", "POWER", "PRICE", "QUANTITY" + ANSI_RESET);
    
    public void addSmartPhone() {
        String code, name, brand, size, ram, cpu;
        double price;
        int quantity, pos;        
        do {
            code = Utils.getID("Input code(SMXXX, X stands for digit): ",
                    "Please input code again with correct format!!!"
                    + "(SMXXX, X stands for digit)", "^SM\\d{3}$");
            pos = searchProductCodeForInput(code);
            if (pos >= 0) {
                System.out.println(ANSI_RED + "The smartphone code already exits."
                        + " Input another one!" + ANSI_RESET);
            }
        } while (pos != -1);
        name = Utils.getString("Input NAME of smartphone: ",
                "Please input NAME of smartphone again!(no empty)");
        brand = Utils.getString("Input BRAND of smartphone: ",
                "Please input BRAND of smartphone again!(no empty)");
        ram = Utils.getString("Input RAM of smartphone: ",
                "Please input RAM of smartphone again!(no empty)");
        cpu = Utils.getString("Input CPU of smartphone: ",
                "Please input CPU of smartphone again!(no empty)");
        size = Utils.getString("Input SIZE of smartphone: ",
                "Please input SIZE of smartphone again!(no empty)");
        price = Utils.getDouble("Input PRICE of smartphone: ",
                "Please input PRICE of smartphone again!(PRICE > 0)", 0);
        quantity = Utils.getInteger("Input QUANTITY of smartphone: ",
                "Please input QUANTITY of smartphone again!(QUANTITY > 0)", 0);                
        listProduct.add(new SmartPhone(ram, cpu, size, code, name, brand, price, quantity));
        listSmartphone.add(new SmartPhone(ram, cpu, size, code, name, brand, price, quantity));
        System.out.println(ANSI_GREEN + "Add new smartphone successfully!" + ANSI_RESET);
    }
    
    public void addTV() {
        String code, name, brand, size;
        double price;
        int quantity, pos;        
        do {
            code = Utils.getID("Input code(TIXXX, X stands for digit): ",
                    "Please input code again with correct format!!!"
                    + "(TIXXX, X stands for digit)", "^TI\\d{3}$");
            pos = searchProductCodeForInput(code);
            if (pos >= 0) {
                System.out.println(ANSI_RED + "The TV code already exits."
                        + " Input another one!" + ANSI_RESET);
            }
        } while (pos != -1);
        name = Utils.getString("Input NAME of TV: ",
                "Please input NAME of TV again!(no empty)");
        brand = Utils.getString("Input BRAND of TV: ",
                "Please input BRAND of TV again!(no empty)");
        size = Utils.getString("Input SIZE of TV: ",
                "Please input SIZE of TV again!(no empty)");
        price = Utils.getDouble("Input PRICE of TV: ",
                "Please input PRICE of TV again!(PRICE > 0)", 0);
        quantity = Utils.getInteger("Input QUANTITY of TV: ",
                "Please input QUANTITY of TV again!(QUANTITY > 0)", 0);
        listProduct.add(new TV(size, code, name, brand, price, quantity));
        listTV.add(new TV(size, code, name, brand, price, quantity));
        System.out.println(ANSI_GREEN + "Add new TV successfully!" + ANSI_RESET);
    }
    
    public void addAirConditioner() {
        String code, name, brand, power;
        double price;
        int quantity, pos;        
        do {
            code = Utils.getID("Input code(AIRXXX, X stands for digit): ",
                        "Please input code again with correct format!!!"
                        + "(AIRXXX, X stands for digit)", "^AIR\\d{3}$");
            pos = searchProductCodeForInput(code);
            if (pos >= 0) {
                System.out.println(ANSI_RED + "The Air-Conditioner code already exits."
                        + " Input another one!" + ANSI_RESET);
            }
        } while (pos != -1);
        name = Utils.getString("Input NAME of Air-Conditioner: ",
                "Please input NAME of Air-Conditioner again!(no empty)");
        brand = Utils.getString("Input BRAND of Air-Conditioner: ",
                "Please input BRAND of Air-Conditioner again!(no empty)");
        power = Utils.getString("Input POWER of Air-Conditioner: ",
                "Please input POWER of Air-Conditioner again!(no empty)");
        price = Utils.getDouble("Input PRICE of Air-Conditioner: ",
                "Please input PRICE of Air-Conditioner again!(PRICE > 0)", 0);
        quantity = Utils.getInteger("Input QUANTITY of Air-Conditioner: ",
                "Please input QUANTITY of Air-Conditioner again!(QUANTITY > 0)", 0);                
        listProduct.add(new AirConditioner(power, code, name, brand, price, quantity));
        listAirConditioner.add(new AirConditioner(power, code, name, brand, price, quantity));
        System.out.println(ANSI_GREEN + "Add new Air-Conditioner successfully!" + ANSI_RESET);
    }
    
    public void printListOfProducts() {
        if (listSmartphone.isEmpty() && listTV.isEmpty() && listAirConditioner.isEmpty()) {
            System.out.println(ANSI_RED + "Product list is empty! Nothing to print." + ANSI_RESET);
        } else {
            if (!listSmartphone.isEmpty()) {
                System.out.println(ANSI_GREEN + "List of all smartphone:" + ANSI_RESET);
                System.out.println(headerSmartphone);
            }                
            for (Product product : listProduct) {
                int check = searchProductCodeForCheck(product.getCode(), "^SM\\d{3}$");
                if (check == 1)
                    ((SmartPhone)product).showDetail();
            }
            
            if (!listTV.isEmpty()) {
                System.out.println(ANSI_GREEN + "List of all TV:" + ANSI_RESET);
                System.out.println(headerTV);
            }                
            for (Product product : listProduct) {
                int check = searchProductCodeForCheck(product.getCode(), "^TI\\d{3}$");
                if (check == 1)
                    product.showDetail();
            }
            
            if (!listAirConditioner.isEmpty()) {
                System.out.println(ANSI_GREEN + "List of all Air-Conditioner:" + ANSI_RESET);
                System.out.println(headerAirConditioner);
            }                
            for (Product product : listProduct) {
                int check = searchProductCodeForCheck(product.getCode(), "^AIR\\d{3}$");
                if (check == 1)
                    product.showDetail();
            } 
        }       
    }
    
    public void printListOfSmartphonesDscByPrice() {
        if (listSmartphone.isEmpty())
            System.out.println(ANSI_RED + "Smartphone list is empty! Nothing to print." + ANSI_RESET);
        else {
            Comparator<SmartPhone> com = new Comparator<SmartPhone>() {
                @Override
                public int compare(SmartPhone o1, SmartPhone o2) {
                    if(o1.getPrice() < o2.getPrice())
                        return 1;
                    else if (o1.getPrice() > o2.getPrice())
                        return -1;
                    return 0;
                }
            };
            Collections.sort(listSmartphone, com);
            
            System.out.println(ANSI_GREEN + "List of all smartphone:" + ANSI_RESET);
            System.out.println(headerSmartphone);                        
            for (SmartPhone smartPhone : listSmartphone) {
                smartPhone.showDetail();
            }
        }            
    }
    
    public void printListOfTVAscByPrice() {
        if (listTV.isEmpty())
            System.out.println(ANSI_RED + "TIVI list is empty! Nothing to print." + ANSI_RESET);
        else {
            Comparator<TV> com = new Comparator<TV>() {
                @Override
                public int compare(TV o1, TV o2) {
                    if(o1.getPrice() > o2.getPrice())
                        return 1;
                    else if (o1.getPrice() < o2.getPrice())
                        return -1;
                    return 0;
                }
            };
            Collections.sort(listTV, com);
            System.out.println(ANSI_GREEN + "List of all TIVI:" + ANSI_RESET);
            System.out.println(headerTV);                        
            for (TV tv : listTV) {
                tv.showDetail();
            }
        }
    }
    
    public void printListOfAirConditionerDscByPrice() {
        if (listAirConditioner.isEmpty())
            System.out.println(ANSI_RED + "Air-Conditioner list is empty! Nothing to print." + ANSI_RESET);
        else {
            Comparator<AirConditioner> com = new Comparator<AirConditioner>() {
                @Override
                public int compare(AirConditioner o1, AirConditioner o2) {
                    if(o1.getPrice() < o2.getPrice())
                        return 1;
                    else if (o1.getPrice() > o2.getPrice())
                        return -1;
                    return 0;
                }
            };
            Collections.sort(listAirConditioner, com);
            System.out.println(ANSI_GREEN + "List of all Air-Conditioner:" + ANSI_RESET);
            System.out.println(headerAirConditioner);                        
            for (AirConditioner airConditioner : listAirConditioner) {
                airConditioner.showDetail();
            }
        }
    }
    
    public void printProductsWithHighestPrices() {
        if (listProduct.isEmpty())
            System.out.println(ANSI_RED + "Product list is empty! Nothing to print." + ANSI_RESET);
        else {
            double max = listProduct.get(0).getPrice();
            for (int i = 0; i < listProduct.size(); i++) {
                if (max < listProduct.get(i).getPrice())
                    max = listProduct.get(i).getPrice();
            }
            int count1 = 0, count2 = 0, count3 = 0;
            for (Product product : listProduct) {
                if (product.getPrice() == max) {
                    if (searchProductCodeForCheck(product.getCode(), "^SM\\d{3}$") == 1) {
                        count1++;
                        if (count1 <= 1)
                            System.out.println(headerSmartphone);
                        product.showDetail();
                    }
                    if (searchProductCodeForCheck(product.getCode(), "^TI\\d{3}$") == 1) {
                        count2++;
                        if (count2 <= 1)
                            System.out.println(headerTV);
                        product.showDetail();
                    }
                    if (searchProductCodeForCheck(product.getCode(), "^AIR\\d{3}$") == 1) {
                        count3++;
                        if (count3 <= 1)
                            System.out.println(headerAirConditioner);
                        product.showDetail();
                    }
                }                
            }
        }
    }

    public void updateProductByCode() {
        if (listProduct.isEmpty())
            System.out.println(ANSI_RED + "Product list is empty! Nothing to update." + ANSI_RESET);
        else {
            String code, name, brand, power, ram, cpu, size;
            double price;
            int quantity;
            code = Utils.getString("Input code for update product(SMXXX or TIXXX or "
                    + "AIRXXX, SM for Smartphone, TI for TIVI, "
                    + "AIR for Air-Conditioner, X stands for digit): ",
                    "Please input code for update again!!!(no empty)");
            SmartPhone searchSM = (SmartPhone) searchProductCodeWithFormat(code, "^SM\\d{3}$");
            TV searchTI = (TV) searchProductCodeWithFormat(code, "^TI\\d{3}$");
            AirConditioner searchAIR = (AirConditioner)searchProductCodeWithFormat(code, "^AIR\\d{3}$");
            if (searchSM != null) {
                System.out.println(ANSI_GREEN + "Smartphone is found. Smartphone in the list before update" + ANSI_RESET);
                System.out.println(headerSmartphone);
                searchProductCode(code).showDetail();
                name = Utils.getString("Update NAME of smartphone: ",
                "Please update NAME of smartphone again!(no empty)");
                brand = Utils.getString("Update BRAND of smartphone: ",
                "Please update BRAND of smartphone again!(no empty)");
                ram = Utils.getString("Update RAM of smartphone: ",
                "Please update RAM of smartphone again!(no empty)");
                cpu = Utils.getString("Update CPU of smartphone: ",
                "Please update CPU of smartphone again!(no empty)");
                size = Utils.getString("Update SIZE of smartphone: ",
                "Please update SIZE of smartphone again!(no empty)");
                price = Utils.getDouble("Update PRICE of smartphone: ",
                "Please update PRICE of smartphone again!(PRICE > 0)", 0);
                quantity = Utils.getInteger("Update QUANTITY of smartphone: ",
                "Please update QUANTITY of smartphone again!(QUANTITY > 0)", 0);
                SmartPhone s = new SmartPhone(ram, cpu, size, code, name, brand, price, quantity);
                update(code, s);
                updateSmartphone(code, s);
                System.out.println(ANSI_GREEN + "Update Smartphone successfully!" + ANSI_RESET);
            } else if (searchTI != null) {
                System.out.println(ANSI_GREEN + "TIVI is found. TIVI in the "
                                        + "list before update" + ANSI_RESET);
                System.out.println(headerTV);
                searchProductCode(code).showDetail();
                name = Utils.getString("Update NAME of TV: ",
                "Please update NAME of TV again!(no empty)");
                brand = Utils.getString("Update BRAND of TV: ",
                "Please update BRAND of TV again!(no empty)");
                size = Utils.getString("Update SIZE of TV: ",
                "Please update SIZE of TV again!(no empty)");
                price = Utils.getDouble("Update PRICE of TV: ",
                "Please update PRICE of TV again!(PRICE > 0)", 0);
                quantity = Utils.getInteger("Update QUANTITY of TV: ",
                "Please update QUANTITY of TV again!(QUANTITY > 0)", 0);
                TV tv = new TV(size, code, name, brand, price, quantity);
                update(code, tv);
                updateTV(code, tv);
                System.out.println(ANSI_GREEN + "Update TIVI successfully!" + ANSI_RESET);
            } else if (searchAIR != null) {
                System.out.println(ANSI_GREEN + "Air-Conditioner is found. "
                        + "Air-Conditioner in the list before update" + ANSI_RESET);
                System.out.println(headerAirConditioner);
                searchProductCode(code).showDetail();
                name = Utils.getString("Update NAME of Air-Conditioner: ",
                "Please update NAME of Air-Conditioner again!(no empty)");
                brand = Utils.getString("Update BRAND of Air-Conditioner: ",
                "Please update BRAND of Air-Conditioner again!(no empty)");
                power = Utils.getString("Update POWER of Air-Conditioner: ",
                "Please update POWER of Air-Conditioner again!(no empty)");
                price = Utils.getDouble("Update PRICE of Air-Conditioner: ",
                "Please update PRICE of Air-Conditioner again!(PRICE > 0)", 0);
                quantity = Utils.getInteger("Update QUANTITY of Air-Conditioner: ",
                "Please update QUANTITY of Air-Conditioner again!(QUANTITY > 0)", 0);
                AirConditioner air = new AirConditioner(power, code, name, brand, price, quantity);
                update(code, air);
                updateAirConditioner(code, air);
                System.out.println(ANSI_GREEN + "Update Air-Conditioner successfully!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Product not found for update!!!" + ANSI_RESET);
            }
        }
    }
    
    public void deleteProductByCode() {
        if (listProduct.isEmpty())
            System.out.println(ANSI_RED + "Product list is empty! Nothing to remove." + ANSI_RESET);
        else {
            String code;
            int answer;
            code = Utils.getString("Input code for delete product(SMXXX or TIXXX or "
                    + "AIRXXX, SM for Smartphone, TI for TIVI, "
                    + "AIR for Air-Conditioner, X stands for digit): ",
                    "Please input code for delete again!!!(no empty)");
            SmartPhone searchSM = (SmartPhone) searchProductCodeWithFormat(code, "^SM\\d{3}$");
            TV searchTI = (TV) searchProductCodeWithFormat(code, "^TI\\d{3}$");
            AirConditioner searchAIR = (AirConditioner)searchProductCodeWithFormat(code, "^AIR\\d{3}$");
            if (searchSM != null) {
                System.out.println(ANSI_GREEN + "Smartphone is found. Smartphone in the list before delete" + ANSI_RESET);
                System.out.println(headerSmartphone);
                searchProductCode(code).showDetail();
                answer = getAnswer();
                if (answer == 1) {
                    remove(code);
                    removeSmartphone(code);
                    System.out.println(ANSI_GREEN + "Smartphone has been removed from the list" + ANSI_RESET);
                }
                else if (answer == -1) {
                    System.out.println(ANSI_RED + "Smartphone will not be deleted!" + ANSI_RESET);
                }                                  
            } else if (searchTI != null) {
                System.out.println(ANSI_GREEN + "TIVI is found. TIVI in the list before delete" + ANSI_RESET);
                System.out.println(headerTV);
                searchProductCode(code).showDetail();
                answer = getAnswer();
                if (answer == 1) {
                    remove(code);
                    removeTV(code);
                    System.out.println(ANSI_GREEN + "TIVI has been removed from the list" + ANSI_RESET);
                }
                else if (answer == -1) {
                    System.out.println(ANSI_RED + "TIVI will not be deleted!" + ANSI_RESET);
                }
            } else if (searchAIR != null) {
                System.out.println(ANSI_GREEN + "Air-Conditioner is found. Air-Conditioner in the list before delete" + ANSI_RESET);
                System.out.println(headerAirConditioner);
                searchProductCode(code).showDetail();
                answer = getAnswer();
                if (answer == 1) {
                    remove(code);
                    removeAirConditioner(code);
                    System.out.println(ANSI_GREEN + "Air-Conditioner has been removed from the list" + ANSI_RESET);
                }
                else if (answer == -1) {
                    System.out.println(ANSI_RED + "Air-Conditioner will not be deleted!" + ANSI_RESET);
                }                
            } else {
                System.out.println(ANSI_RED + "Product not found for remove!!!" + ANSI_RESET);
            }
        }
    }
    
    public void totalAmount() {
        double sum = 0;
        for (Product product : listProduct) {
            sum += product.getPrice() * product.getQuantity();
        }
        System.out.println(ANSI_BLUE + "Total amount of all products: " + ANSI_RESET + sum);
    }
    
    public int getAnswer() {
        int answer;
        answer = Utils.getYesNo("Do you want to remove product in the list?(yes or no)"
                                                            , "Please answer yes or no!!!");
        return answer;
    }
    
    public int getAnswerForAdd() {
        int answer;
        answer = Utils.getYesNo("Do you want to add more product?(yes or no)",
                                                            "Please answer yes or no!!!");
        return answer;
    }
    
    public int searchProductCodeForCheck(String code, String format) {
        boolean match;
        match = code.matches(format);
        if (match == false)
            return -1;
        else
            return 1;
    }
    
    public int searchProductCodeForInput(String code) {
        if (listProduct.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public Product searchProductCode(String code) {
        if (listProduct.isEmpty()) {
            return null;
        }
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getCode().equals(code)) {
                return listProduct.get(i);
            }
        }
        return null;
    }
    
    public Product searchProductCodeWithFormat(String code, String format) {
        boolean match;
        match = code.matches(format);
        if (match == true) {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getCode().equals(code)) {
                    return listProduct.get(i);
                }
            }
        }
        return null;
    }
    
    public void remove(String code) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getCode().equals(code)) {
                listProduct.remove(i);
                break;
            }                
        }
    }
    
    public void removeSmartphone(String code) {
        for (int i = 0; i < listSmartphone.size(); i++) {
            if (listSmartphone.get(i).getCode().equals(code)) {
                listSmartphone.remove(i);
                break;
            }                
        }
    }
    
    public void removeTV(String code) {
        for (int i = 0; i < listTV.size(); i++) {
            if (listTV.get(i).getCode().equals(code)) {
                listTV.remove(i);
                break;
            }                
        }
    }
    
    public void removeAirConditioner(String code) {
        for (int i = 0; i < listAirConditioner.size(); i++) {
            if (listAirConditioner.get(i).getCode().equals(code)) {
                listAirConditioner.remove(i);   
                break;
            }                
        }
    }
    
    public void update(String code, Product p) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getCode().equals(code)) {
                listProduct.set(i, p);
                break;
            }                
        }
    }
    
    public void updateSmartphone(String code, SmartPhone p) {
        for (int i = 0; i < listSmartphone.size(); i++) {
            if (listSmartphone.get(i).getCode().equals(code)) {
                listSmartphone.set(i, p);
                break;
            }                
        }
    }
    
    public void updateTV(String code, TV p) {
        for (int i = 0; i < listTV.size(); i++) {
            if (listTV.get(i).getCode().equals(code)) {
                listTV.set(i, p);
                break;
            }                
        }
    }
    
    public void updateAirConditioner(String code, AirConditioner p) {
        for (int i = 0; i < listAirConditioner.size(); i++) {
            if (listAirConditioner.get(i).getCode().equals(code)) {
                listAirConditioner.set(i, p);
                break;
            }                
        }
    }
}
