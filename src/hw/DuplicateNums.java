package hw;

import java.util.ArrayList;
import java.util.List;

/**
 * //给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * //
 * // 找到所有出现两次的元素。
 * //
 * // 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * //
 * // 示例：
 * //
 * //
 * //输入:
 * //[4,3,2,7,8,2,3,1]
 * //
 * //输出:
 * //[2,3]
 * //
 * // Related Topics 数组
 */
public class DuplicateNums {
    public static void main(String[] args) {

    }
    public  static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
