package Assignment4;

public class Circle extends Shape{

    private double radius;

    public void draw(){
        System.out.println("Drawing Circle");
    }

    public Circle(double radius){
        super(3.14125 * 2 * radius, 3.14125 * radius * radius);
        this.radius = radius;
    }

}
