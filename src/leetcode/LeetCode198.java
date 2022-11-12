package leetcode;

public class LeetCode198 {
    public static void main(String[] args) {
        int[] nums =new int[]{2,7,9,3,1};
    }

    public static int getMoney(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length ==1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0]?nums[1]:nums[0];

        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);

        }
        return dp[nums.length-1];
    }
}
