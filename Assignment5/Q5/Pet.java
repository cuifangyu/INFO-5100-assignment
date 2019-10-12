package Assignment5A;

public class Pet {

    private String petName;
    private String ownerName;
    private String color;
    private int sexid;

    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int SPAYED = 3;
    public static final int NEUTERED = 4;

    public Pet(String petName, String ownerName, String color){
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return petName;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public String getColor() {
        return color;
    }
    public void setSex(int sexid){
        if(sexid < 1 || sexid > 4){
            throw new IllegalArgumentException("No Valid Input");
        }
        this.sexid = sexid;
    }
    public String getSex(){
        if(sexid == MALE){
            return "Male";
        } else if(sexid == FEMALE){
            return "Female";
        } else if(sexid == SPAYED){
            return "Spayed";
        } else if(sexid == NEUTERED){
            return "Neutered";
        } else {
            return null;
        }
    }

    public String toString(){
        String s = getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex();
        return s;
    }

}


