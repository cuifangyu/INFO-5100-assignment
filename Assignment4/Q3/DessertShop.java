package Assignment4;

public class DessertShop {

    public static final String name = "M & M Dessert Shop";
    public static final double taxRate = 0.065;
    public static final int maxItemNameSize = 50;
    public static final int displayWidth = 50;

    public static String cent2dollarsAndCents(int centNumber){
        double result = (double)centNumber / 100;
        String s = Double.toString(result);
        return s;
    }
}
