package Assignment5;

public class Number {

    public double count(int num1, int num2){
        try {
            double result = num1 / num2;
            return result;
        } catch (Exception e) {
            System.out.println("Not Available");
            return 0;
        }
    }

}
