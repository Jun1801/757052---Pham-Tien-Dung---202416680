package demo;
import aims.cart.Cart;
import aims.disc.DigitalVideoDisc;
import aims.store.Store;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aims {
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static Store initStore(){
        Store store = new Store();
        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dv2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dv3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dv4 = new DigitalVideoDisc("One Piece", "Anime", "Oda", 100,  30.95f);
        DigitalVideoDisc dv5 = new DigitalVideoDisc("Doraemon", "Animation", "Fujiko Fuijo", 50, 17.95f);
        DigitalVideoDisc dv6 = new DigitalVideoDisc("Harry Potter", "Detective", "J.K.Rowling", 90, 23.15f);
        DigitalVideoDisc dv7 = new DigitalVideoDisc("Naruto", "Anime", "Masashi", 50, 13.55f );
        DigitalVideoDisc dv8 = new DigitalVideoDisc("Titanic", "Romantic Disaster", "James Cameron", 180, 40.95f);
        DigitalVideoDisc dv9 = new DigitalVideoDisc("The Conjuring 2", "Horror", "James Wan", 180, 39.95f);
        DigitalVideoDisc dv10 = new DigitalVideoDisc("The Nun", "Horror", "James Wan", 100, 24.55f);
        store.addDVD(dv1);
        store.addDVD(dv2);
        store.addDVD(dv3);
        store.addDVD(dv4);
        store.addDVD(dv5);
        store.addDVD(dv6);
        store.addDVD(dv7);
        store.addDVD(dv8);
        store.addDVD(dv9);
        store.addDVD(dv10);
        return store;
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Store store = initStore();
        System.out.println("----------AIMS STORE-------------");
        System.out.println("Available DVDs");
        store.getInfo();
        System.out.println("---------------------------------");
/* 
                
        Cart anOrder = new Cart();
        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dv1);

        DigitalVideoDisc dv2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dv2);

        DigitalVideoDisc dv3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dv3);

        System.out.println("Total cost is: "+ anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dv3);
        System.out.println(anOrder.getNumofOrders());
*/
        Cart cart1 = new Cart();

        System.out.println("---------------MENU---------------");
        System.out.println("1. Add the disc to cart");
        System.out.println("2. Remove the cart to cart");
        System.out.println("3. Number of discs in the cart");
        System.out.println("4. Total cost");
        System.out.println("5. Show orders");
        System.out.println("6. Show available DVDs");
        System.out.println("7. Exit");
        while(true){
            System.out.print("Please enter the number to give your choice (1 - 7): ");

            String input = s.nextLine();
            if (isInteger(input)){
                int choice = Integer.parseInt(input);
            

            if (choice == 1){
                
                System.out.print("Enter ID disc / disc's title: ");
                String answer = s.nextLine();
                if (isInteger(answer)){
                    int id = Integer.parseInt(answer);
                    if (id > store.getNumberDVDs()){
                        System.out.println("Invalid disc! Please try again");
                        continue;
                    }
                    cart1.addDigitalVideoDisc(store.items.get(id - 1));
                }
                else{
                    
                    DigitalVideoDisc found_disc = store.findDVD(answer);
                    if (found_disc != null){
                        cart1.addDigitalVideoDisc(found_disc);
                    }
                    else{
                        System.out.println("Invalid disc! Please try again");
                        continue;                       
                    }
                }
            }

            else if (choice == 2){
                System.out.print("Enter ID disc / disc's title: ");
                String answer = s.nextLine();
                if (isInteger(answer)){
                    int id = Integer.parseInt(answer);
                    if (id > store.getNumberDVDs()){
                        System.out.println("Invalid disc! Please try again");
                    }
                    else cart1.removeDigitalVideoDisc(store.items.get(id - 1));
                    continue;
                }
                else{
                    DigitalVideoDisc found_disc = store.findDVD(answer);
                    if (found_disc != null){
                        cart1.removeDigitalVideoDisc(found_disc);
                    }
                    else{
                        System.out.println("Invalid disc! Please try again");
                                              
                    }
                    continue;
                }

            }
            else if (choice == 3){
                System.out.println("The number of orders in the cart: " + cart1.getNumofOrders());
                continue;
            }
            else if (choice == 4){
                System.out.printf("Total cost: $%.2f%n", cart1.totalCost());
            }
            else if (choice == 5){
                System.out.println("Your order here");
                cart1.printAllOrders();
            }
            else if (choice == 7){
                System.out.println("Thanks for using our service.");
                System.exit(0);
            }
            else if (choice == 6){
                store.getInfo();
            }
            else{
                System.out.println("Invalid! Please try again");
                continue;
            }

        }
        else{
            System.out.println("Invalid input! Please enter an integer number (1 - 7)");
        }
    }   
    }
}
