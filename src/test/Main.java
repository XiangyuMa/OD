package test;

/**
 * @author :马翔宇
 * @description
 * 百度一面
 * 最长连续递增子序列
 *         输入: nums = [1, 3, 5, 4, 7]
 *         输出: 3
 *         解释: 最长连续递增子序列是 [1, 3, 5]，长度为 3。
 *
 * @date: 2024/9/9 17:35
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {1,3,5,4,7,8,9,0,3,4,6,7,9,12};
        int [] dp = new int[nums.length];

        dp[0] = 1;
        for(int i = 1;i < nums.length;i++){

            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = Math.min(1,dp[i-1]);
            }

        }
        int max = 0;
        for(int i =0;i <dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
