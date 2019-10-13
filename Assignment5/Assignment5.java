package Assignment5;

public class Assignment5 {

    //Explain the difference between `final` and `finally` in Java 8.

    /*
    "final" is used in class/method/variable to make it unchangeable.
    If a class is final, it can not be inherited by another Class.
    If a method is final, it can not be override in subclass.
    If a variable is final, it can not be assigned to another value.

    "finally" is generally used when dealing with exceptions.
    We can use try...catch...finally... to deal with exceptions.
    The statement in "finally" will always be executed.
     */


    //Extra Credits

    /*
    The answer is 6. The result of getAddCount is 6 and the result of getI is 0.

    When b use addAll method, as the method is override, it will call the override method in B class.
    So first addCount will be 0 + 3 = 3;
    Then it uses super to call the method in A class. In the addCount method in A class, it calls the add method.
    As B class override the add method, it will call the method in B class instead of A.
    When each element is added into the list, addCount will add 1.
    So after the whole process, the addCount number will be 6.

    When b use getI method, as it is not override in B, it will call the method in A class.
    When a method calls a member variable, the variable it chooses depends on the class of method being defined.
    So the method of getI will use the I in A class, which is 0.
    So the result of getI is 0.

    So, the sum of addCount and getI is 6.
     */

}
