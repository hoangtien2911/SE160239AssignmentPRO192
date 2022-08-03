
package GUI;

import MyUtils.Utils;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList<>();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String option) {
        optionList.add(option);
    }
    
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in menu");
            return;            
        }
        System.out.println("============================================"
                         + "==========================");
        System.out.println("Welcome to " + menuTitle);
        System.out.println("Select the options below:");
        for (String s : optionList) {
            System.out.println(s);
        }
    }
    
    public void printMenuQuestion() {
        System.out.println(menuTitle);
        System.out.println("Select the options below:");
        for (String s : optionList) {
            System.out.println(s);
        }
    }
    
    public int getchoice() {
        int maxOption = optionList.size();
        String inputMsg = "Your choice 1..." + maxOption +": ";
        String errorMsg = "Please choice 1..." + maxOption + "!";
        int choice = Utils.getInteger(inputMsg, errorMsg, 1, maxOption);
        return choice;
    }
}
