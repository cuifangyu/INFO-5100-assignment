package Assignment4;

import java.util.Vector;

public class Checkout {

    protected Vector<DessertItem> dessertItemVector;


    public Checkout(){
        dessertItemVector = new Vector<>();
    }


    public int numbersOfItems(){
        return dessertItemVector.size();
    }

    public void enterItem(DessertItem item){
        dessertItemVector.add(item);
    }

    public void clear(){
        dessertItemVector.clear();
    }

    public int totalCost(){
        int total = 0;
        for(int i = 0; i < dessertItemVector.size(); i++){
            int cost = dessertItemVector.get(i).getCost();
            total += cost;
        }
        return total;
    }

    public int totalTax(){
        int cost = totalCost();
        int tax = (int) Math.round(cost * DessertShop.taxRate);
        return tax;
    }

    public String toString(){
        String s1 = "\n      " + DessertShop.name;
        String s2 = "\n      " + "------------------" + "\n";
        String s3 = new String();
        for(int i = 0; i < dessertItemVector.size(); i++){
            String s = new String();
            if(dessertItemVector.get(i) instanceof Candy){
                s = ((Candy) dessertItemVector.get(i)).weight + " lbs. @ " + DessertShop.cent2dollarsAndCents((int)((Candy) dessertItemVector.get(i)).pricePerPound) + " /lb.\n" + s;
            } else if(dessertItemVector.get(i) instanceof Cookie){
                s = ((Cookie) dessertItemVector.get(i)).number + " lbs. @ " + DessertShop.cent2dollarsAndCents((int)((Cookie) dessertItemVector.get(i)).pricePerDozen) + " /dz.\n" + s;
            }
            String name = dessertItemVector.get(i).name;
            if(name.length() > DessertShop.displayWidth){
                name = name.substring(0, 29);
            }
            s = s + name;
            s = s + "\t\t" + DessertShop.cent2dollarsAndCents(dessertItemVector.get(i).getCost());
            s3 = s3 + "\n" + s;

        }
        String s4 = "\n\nTax\t\t\t\t\t\t" + DessertShop.cent2dollarsAndCents(totalTax());
        String s5 = "\nTotal Cost\t\t\t\t" + DessertShop.cent2dollarsAndCents(totalCost() + totalTax());
        return s1 + s2 + s3 + s4 + s5 +"\n\n";
    }
}
