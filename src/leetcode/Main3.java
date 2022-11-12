package leetcode;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/5 13:21
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i = 1;i < n;i++){
            dp[i][0] = arr[i][0] + dp[i-1][0];
        }
        for(int j = 1;j < n;j++){
            dp[0][j] = arr[0][j] + dp[0][j-1];
        }

        for(int i = 1;i < arr.length;i++){
            for(int j = 1;j < arr[0].length;j++){
               dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
            }
        }
        System.out.println( dp[n-1][n-1]);

    }


}
