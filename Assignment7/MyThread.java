package Assignment7;

public class MyThread extends Thread{
    private int[] arr;
    private int low;
    private int high;
    private int sum;

    public MyThread(int[] arr, int low, int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void run(){
        int result = 0;
        for(int i = low; i < high; i++){
            result += arr[i];
        }
        sum = result;
    }

    public int getResult() {
        return sum;
    }
}
