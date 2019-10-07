package Assignment4;

public class Shape {

    protected String name;
    protected double perimeter;
    protected double area;

    public void draw(){
        System.out.println("Drawing Shape");
    }

    public double getArea() {
        System.out.println(area);
        return area;
    }

    public double getPerimeter() {
        System.out.println(perimeter);
        return perimeter;
    }

    public Shape(){

    }

    public Shape(double perimeter, double area){
        this.perimeter = perimeter;
        this.area = area;
    }
}
