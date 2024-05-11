package honor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description：
 * 给定一个整形数组arr，返回排序后相邻两数的最大差值
 * arr = [9, 3, 1, 10]。如果排序，结果为[1, 3, 9, 10]，9和3的差为最大差值，故返回6。
 * @date: 2024/5/10 16:06
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[]{9,3,1,10};
        System.out.println(getMaxDifferenceOfTwoNums(arr));
        scanner.close();
    }
    public static int getMaxDifferenceOfTwoNums(int[] arr) {
        int[] dp = new int[arr.length];
        if(arr.length == 1){
            return -1;
        }
        Arrays.sort(arr);
        for(int i = 0;i < arr.length;i++){
            if(i == 0) {
                dp[i] = Math.abs(arr[i+1] - arr[i]);
                continue;
            }
            if(i == arr.length -1){
                dp[i] = Math.abs(arr[i] - arr[i-1]);
                continue;
            }
            dp[i] = Math.max(Math.abs(arr[i] - arr[i-1]),Math.abs(arr[i] - arr[i+1]));

        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
