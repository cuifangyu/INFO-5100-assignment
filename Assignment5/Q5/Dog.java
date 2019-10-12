package Assignment5D;

import Assignment5A.Pet;
import Assignment5B.Boardable;

public class Dog extends Pet implements Boardable {

    private String size;
    private int boardingStart;
    private int boardingEnd;

    public Dog(String name, String ownerName, String color, String size){
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        return "DOG:\n" + super.toString() + "\nSize: " + getSize();
    }


    public void setBoardStart(int month, int day, int year) {
        if(month < 1 || month > 12 || day < 1 || day > 31 || year < 1000 || year > 9999){
            throw new IllegalArgumentException("No Valid Date");
        }
        boardingStart = year * 10000 + month * 100 + day;
    }

    public void setBoardEnd(int month, int day, int year) {
        if(month < 1 || month > 12 || day < 1 || day > 31 || year < 1000 || year > 9999){
            throw new IllegalArgumentException("No Valid Date");
        }
        boardingEnd = year * 10000 + month * 100 + day;
    }

    public boolean boarding(int month, int day, int year) {
        if(boardingStart == 0 || boardingEnd == 0 || boardingStart > boardingEnd){
            throw new IllegalArgumentException("Please Set Valid Boarding Start & End Date!");
        }
        int date = year * 10000 + month * 100 + day;
        if(date < boardingStart || date > boardingEnd){
            return false;
        } else {
            return true;
        }
    }

}
