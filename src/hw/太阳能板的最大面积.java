package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:08
 */
public class 太阳能板的最大面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 没图 题目大概的意思就是：数组两个元素的间距 乘以 两个元素中的最小值，取最大的，就是太阳能板的最大面积了
    // 太阳能板最大面积
    public static void test() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(",");
        int len = split.length;
        // 结果
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int area = Math.min(Integer.parseInt(split[i]), Integer.parseInt(split[j])) * (j - i);
                res = Math.max(res, area);
            }
        }
        System.out.println(res);
    }

}
