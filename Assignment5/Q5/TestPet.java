package Assignment5E;

import Assignment5A.Pet;
import Assignment5C.Cat;
import Assignment5D.Dog;

public class TestPet {

    public static void main(String[] args) {
        Pet a = new Pet("Spot", "Mary", "Black and White");
        a.setSex(1);
        System.out.println(a);
        Cat b = new Cat("Tom", "Bob", "Black", "Short");
        b.setSex(3);
        System.out.println(b);
        Dog c = new Dog("Spot", "Susan", "White", "Medium");
        c.setSex(3);
        System.out.println(c);
        b.setBoardStart(6, 8, 1967);
        b.setBoardEnd(10, 2, 1994);
        System.out.println(b.boarding(8, 25, 1969));
        c.setBoardStart(6, 8, 1967);
        c.setBoardEnd(10, 2, 1994);
        System.out.println(c.boarding(6, 6, 1967));
    }

}
