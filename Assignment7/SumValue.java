package Assignment7;

import java.util.Random;

public class SumValue {

    static void generateRandomArray(int[] arr){
        Random random = new Random();
        for(int i = 0; i < 4000000; i++){
            arr[i] = random.nextInt();
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        MyThread t1 = new MyThread(arr, 0, arr.length / 4);
        MyThread t2 = new MyThread(arr, arr.length / 4, arr.length / 2);
        MyThread t3 = new MyThread(arr, arr.length / 2, arr.length * 3 / 4);
        MyThread t4 = new MyThread(arr, arr.length * 3 / 4, arr.length);
        t1.run();
        t2.run();
        t3.run();
        t4.run();
        return t1.getResult() + t2.getResult() + t3.getResult() + t4.getResult();
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }

}
