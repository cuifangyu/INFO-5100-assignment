package Assignment4;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public void draw(){
        System.out.println("Drawing Rectangle");
    }

    public Rectangle(double width, double height){
        super(width * 2 + height * 2, width * height);
        this.width = width;
        this.height = height;
    }

}
