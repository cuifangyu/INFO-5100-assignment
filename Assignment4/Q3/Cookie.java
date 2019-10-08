package Assignment4;

public class Cookie extends DessertItem {

    protected int number;
    protected double pricePerDozen;

    public Cookie(String name, int number, double pricePerDozen){
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getCost() {
        int cost = (int) Math.round(number * pricePerDozen / 12);
        return cost;
    }

}
