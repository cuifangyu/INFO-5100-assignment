package Assignment4;

public class IceCream extends DessertItem{

    protected int cost;

    public IceCream(String name, int cost){
        super(name);
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

}
