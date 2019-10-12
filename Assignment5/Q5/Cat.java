package Assignment5C;

import Assignment5A.Pet;
import Assignment5B.Boardable;

public class Cat extends Pet implements Boardable {

    private String hairLength;
    private int boardingStart;
    private int boardingEnd;

    public Cat(String name, String ownerName, String color, String hairLength){
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength(){
        return hairLength;
    }

    public String toString(){
        return "CAT:\n" + super.toString() + "\nHair: " + getHairLength();
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
