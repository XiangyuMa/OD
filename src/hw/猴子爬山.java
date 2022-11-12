package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description 动态规划、递归
 * @date: 2022/11/4 15:53
 */
public class 猴子爬山 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    /**
     * 解题思路：
     * 动态规划题，找规律
     * n = 1  1
     * n = 2  1
     * n = 3  2
     * n = 4  3
     * n = 5  4
     * n = 6  6
     * n = 7  9
     * 可得当n > 3时 f(n) = f(n - 1) + f(n - 3)
     * 所以可以用递归，n = 1/2/3 时值是固定的，为递归结束条件
     */
    // 猴子爬山
    public static void test004() {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int value = fun(nums);
        System.out.println(value);
    }
    private static int fun(int nums) {
        // 递归结束条件
        if (nums == 1 || nums == 2) {
            return 1;
        }
        // 递归结束条件
        if (nums == 3) {
            return 2;
        }
        // 规律
        return fun(nums - 1) + fun(nums - 3);
    }

}
