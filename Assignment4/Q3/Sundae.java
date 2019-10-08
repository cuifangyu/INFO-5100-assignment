package Assignment4;

public class Sundae extends IceCream {

    protected int costOfTopping;

    public Sundae(String name, int cost, String nameOfTopping, int costOfTopping){
        super(nameOfTopping + " Sundae with\n" + name, cost);
        this.costOfTopping = costOfTopping;
    }

    public int getCost() {
        int c = cost + costOfTopping;
        return c;
    }

}
