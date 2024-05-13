import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2024/5/13 14:24
 */
public class H3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        for(int i = 0;i < arr.length-2;i++){
            for(int j = i+1;j < arr.length-1;j++){
                for(int m = j+1;m < arr.length;m++){
                    if(arr[i] + arr[j] + arr[m] == k){
                        if(arr[i] == arr[j] || arr[i] == arr[m] || arr[j] == arr[m]){
                            continue;
                        }
                        System.out.println(arr[i] + " " + arr[j] + " "+ arr[m]);
                    }
                }
            }
        }
        scanner.close();
    }
}
