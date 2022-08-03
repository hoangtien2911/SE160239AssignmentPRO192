package GUI;

import DTO.Cabinet;
/**
 *
 * @author Hp
 */
public class ProductManagement {

    public static void main(String[] args) {
        Cabinet cage = new Cabinet();
        int choice, choiceQuestion;
        Menu menu = new Menu("Product Management - @ 2022 by <SE160239 - Phạm Hoàng Tiến>");
        menu.addNewOption("1. Add a new product. ");
        menu.addNewOption("2. Print out the list of products on the screen.");
        menu.addNewOption("3. Print a list of Smartphones in descending order of price.");
        menu.addNewOption("4. Print a list of Tivis in Ascending order of price.");
        menu.addNewOption("5. Print a list of of Air-conditioner  in descending order of price.");
        menu.addNewOption("6. Print information about products with the highest prices.");
        menu.addNewOption("7. Update the product information based on the code the user entered.");
        menu.addNewOption("8. Delete an product based on the code the user entered.");
        menu.addNewOption("9. Print the total amount of all products ");
        menu.addNewOption("10. Exit the program.");
        do {
            menu.printMenu();
            choice = menu.getchoice();
            switch (choice) {
                case 1:  
                    int answer;
                    do {
                        Menu menuQuestion = new Menu("Choice type of product you want to add:");
                        menuQuestion.addNewOption("1. Smartphone");
                        menuQuestion.addNewOption("2. TIVI");
                        menuQuestion.addNewOption("3. Air-Conditioner");
                        menuQuestion.printMenuQuestion();
                        choiceQuestion = menuQuestion.getchoice();
                        switch (choiceQuestion) {
                            case 1:
                                System.out.println("You are preparing to input new Smartphone.");
                                cage.addSmartPhone();                                
                                break;
                            case 2:
                                System.out.println("You are preparing to input new TV.");
                                cage.addTV();                                
                                break;
                            case 3:
                                System.out.println("You are preparing to input new Air-Conditioner.");
                                cage.addAirConditioner();                                       
                                break;                            
                        }
                        answer = cage.getAnswerForAdd();
                    } while (answer == 1);                    
                    break;
                case 2:
                    System.out.println("You are required to print list of products.");
                    cage.printListOfProducts();
                    break;
                case 3:
                    System.out.println("You are required to print list of "
                            + "Smartphones in descending order of price.");
                    cage.printListOfSmartphonesDscByPrice();
                    break;
                case 4:
                    System.out.println("You are required to print list of "
                            + "Tivis in ascending order of price");
                    cage.printListOfTVAscByPrice();
                    break;
                case 5:
                    System.out.println("You are required to print list of "
                            + "Air-conditioner  in descending order of price");
                    cage.printListOfAirConditionerDscByPrice();
                    break;
                case 6:
                    System.out.println("You are required to print information "
                            + "about products with the highest prices");
                    cage.printProductsWithHighestPrices();
                    break;
                case 7:
                    System.out.println("You are required to input "
                            + "a product code to update.");
                    cage.updateProductByCode();
                    break;
                case 8:
                    System.out.println("You are required to input "
                            + "a student code to delete.");
                    cage.deleteProductByCode();
                    break;
                case 9:
                    System.out.println("You are required to print the total "
                            + "amount of all products.");
                    cage.totalAmount();
                    break;
                case 10:
                    System.out.println("Bye bye, see you next time.");
                    break;
            }
        } while (choice != 10);
    }
}
