package Assignment4;

public class Square extends Shape{

    private double side;

    public void draw(){
        System.out.println("Drawing Square");
    }

    public Square(double side){
        super(4 * side, side * side);
        this.side = side;
    }

}
