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
        for(int i=0;i<arr.length-3;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arr.length -1;
            int middleValue = k - arr[i];
            while(left<right){
                if(arr[left]+arr[right]<middleValue){
                    left++;
                }else if(arr[left]+arr[right]>middleValue){
                    right--;
                }else{
                    if(arr[left]==0||arr[left]!=arr[left-1]&&arr[left]!=arr[right]){
                        System.out.println(arr[i]+" "+arr[left]+" "+arr[right]);
                    }
                    left++;
                    right--;
                }
            }
        }
        scanner.close();
    }
}
