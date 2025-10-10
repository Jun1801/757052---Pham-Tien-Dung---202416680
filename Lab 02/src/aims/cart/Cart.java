package aims.cart;

import aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private static int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full.");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvdlist[]){
        if (qtyOrdered + dvdlist.length <= MAX_NUMBERS_ORDERED){
            for(int i=0; i<dvdlist.length; i++){
                itemsOrdered[qtyOrdered] = dvdlist[i];
                qtyOrdered++;
                System.out.println("The disc list has been added.");
            }
        }
        else{
            System.out.println("The cart is full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered > 0){
            for(int i=0; i<qtyOrdered; i++){
                if (itemsOrdered[i].getTitle().equals(disc.getTitle())){
                    for(int j=i; j< qtyOrdered-1; j++){
                        itemsOrdered[j] = itemsOrdered[j+1];
                    }
                    qtyOrdered--;
                    System.out.println("The disc has been removed.");
                    return;
                }
            }
            System.out.println("The disc is not in the cart.");
        }
        else{
            System.out.println("The cart is empty");
        }
    }

    public static int getNumofOrders(){
        return qtyOrdered;
    }

    public float totalCost(){
        float total = 0;
        for (int i=0; i<qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print(String title){
        if (qtyOrdered > 0){
            for (int i=0; i<qtyOrdered; i++){
                if (itemsOrdered[i].isMatch(title)){
                    System.out.println(itemsOrdered[i].toString());
                    return;
                }
            }
            System.out.println("The disc is not in the cart.");
        }
        else{
            System.out.println("The disc is empty.");
        }
    }

    public void print(int id){
        if (qtyOrdered > 0){
            for (int i=0; i<qtyOrdered; i++){
                if (itemsOrdered[i].getID() == id){
                    System.out.println(itemsOrdered[i].toString());
                    return;
                }
            }
            System.out.println("The disc is not in the cart.");
        }
        else{
            System.out.println("The cart is empty.");
        }
    }

    public void printAllOrders(){
        for (int i=0; i<qtyOrdered; i++){
            System.out.println(itemsOrdered[i].toString());
        }
    }
    
}
