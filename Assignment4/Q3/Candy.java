package Assignment4;

public class Candy extends DessertItem {

    protected double weight;
    protected double pricePerPound;

    public Candy(String name, double weight, double pricePerPound){
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public int getCost() {
        int cost = (int) Math.round(weight * pricePerPound);
        return cost;
    }

}
