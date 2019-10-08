package Assignment4;

public abstract class DessertItem {

    protected String name;

    public DessertItem(){}

    public DessertItem(String name){
        if(name.length() > DessertShop.maxItemNameSize){
            throw new IllegalArgumentException("Name is too long!");
        }
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract int getCost();

}
