package od;

import java.util.Scanner;

/**
 * @author :OD机考第三题
 * @description 有几个基站 要从第一个基站走到最后一个然后再回到第一个基站  A基站到B基站的距离 和 B基站到A基站的距离不同
 * 输出最小距离
 * @date: 2022/11/5 13:21
 */
public class OD_jizhan_juli {
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
