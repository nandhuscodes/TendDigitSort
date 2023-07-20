import java.util.Arrays;
import java.util.Scanner;

public class TenDigitSorting {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(tenDigitSort(array)));
    }
    static int[] tenDigitSort(int[] arr){
        int res[] = new int[arr.length];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int[] count = new int[arr.length];
        Arrays.fill(count,0);
        for(int i = 0; i < arr.length; i++){
            count[(arr[i]/10)%10]++;
        }
        for(int i = 1; i < arr.length; i++){
            count[i] += count[i-1];
        }
        for(int i = 0; i < arr.length; i++){
            res[count[(arr[i]/10)%10]-1] = arr[i];
            count[(arr[i]/10)%10]--;
        }
        return res;
    }
}
