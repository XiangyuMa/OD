package honor;

/**
 * @author :马翔宇
 * @description leetcode 486
 *
 * @date: 2024/5/10 18:20
 */
public class H1008749 {
    public static void main(String[] args) {

    }
    public boolean predictTheWinner(int[] nums) {
        int length = nums.length;
        int dp[][] = new int[length][length];
        for(int i = 0;i < length;i++){
            dp[i][i] = nums[i];
        }
        for(int i = length -2;i>=0;i--){
            for (int j = i + 1;j< length;j++){
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][length-1] >= 0;
    }
}
