package Assignment5;

public class FullTime extends Employee {

    public FullTime(String name, int paymentPerHour){
        super(name, paymentPerHour);
    }

    public int calculateSalary() {
        return getPaymentPerHour() * 8;
    }

}
