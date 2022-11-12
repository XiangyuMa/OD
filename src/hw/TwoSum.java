package hw;

import java.util.HashMap;
import java.util.Map;


/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/12 22:58
 */
public class TwoSum {
    public static void main(String[] args) {
    }
    //暴力破解
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};

    }
    //hashmap查找
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int other = target - nums[i];
            if(map.containsKey(other) && map.get(other) != i){
                return new int[]{i,map.get(other)};
            }
        }
        return new int[]{-1,-1};

    }
}
