package Assignment5;

public class TestIndex {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 10;
        if(index < 0 || index > arr.length - 1 ){
            throw new MyIndexOutOfBoundException(0, arr.length - 1, index);
        }
        System.out.println(arr[index]);
    }

}
