import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(long[] arr) {
        long max = 0;
        long min = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i == 0){
                min+= arr[i];
                continue;
            }
            if(i == arr.length-1){
                max+= arr[i];
                continue;
            }
            min+= arr[i];
            max+= arr[i];
        }
        System.out.println((min)+" "+(max));
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long[] arr = new long[5];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        miniMaxSum(arr);
        scanner.close();
    }
}