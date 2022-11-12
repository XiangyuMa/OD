package leetcode;

import java.util.Arrays;

/**
 * 动态规划类问题求解
 */
public class Dp {
    public static void main(String[] args) {

    }

    /**
     * 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i =1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i =1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i =1;i< m;i++){
            for(int j =1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp,1);

        for(int i = 0;i<length;i++){
            for(int j =0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i =0; i < length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 编辑距离 LeetCode 72
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //base case
        for(int i = 1;i<= m;i++){
            dp[i][0] = i;
        }
        for(int j = 1;j<= n;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i <=m;i++){
            for( int j =1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    /**
     * 高楼扔鸡蛋 LeetCode 887
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }

        for (int j = 2; j <= k; ++j) {
            // Now, we will develop dp2[i] = dp(j, i)
            int[] dp2 = new int[n + 1];
            int x = 1;
            for (int m = 1; m <= n; ++m) {
                // Let's find dp2[m] = dp(j, m)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[m-x]) > max(dp[x], dp2[m-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < m && Math.max(dp[x - 1], dp2[m - x]) > Math.max(dp[x], dp2[m - x - 1])) {
                    x++;
                }

                // The final answer happens at this x.
                dp2[m] = 1 + Math.max(dp[x - 1], dp2[m - x]);
            }

            dp = dp2;
        }

        return dp[n];
    }
   public  int superEggDrop2(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
          // dp[0][..] = 0 // dp[..][0] = 0 // Java 默认初始化数组都为 0
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }


}
