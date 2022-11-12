package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 21:59
 */
public class MinString {
    public static void main(String[] args) {
       test();
    }
    // 最小字符串
    // 解题思路：遍历每一个元素，找到最小的，与第一个元素交换，如果第一个元素是最小的，则找第二个元素与第二小的元素交换，以此类推
    public static void test() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        // 遍历每一个元素
        for (int j = 0; j < chars.length; j++) {
            // 存放最小的元素
            char minValue = chars[j];
            // 存放最小元素的索引
            int minIndex = j;
            // 遍历往后的所有元素
            for (int i = j + 1; i < chars.length; i++) {
                // 使用<=是因为要拿到排在最后的最小元素
                if (chars[i] <= minValue) {
                    minValue = chars[i];
                    minIndex = i;
                }
            }
            // 当最小元素不是第一个时，则交换第一个元素与最小元素的位置，输出后结束
            if (minIndex != j && chars[j] != chars[minIndex]) {
                chars[minIndex] = chars[j];
                chars[j] = minValue;
                System.out.println(new String(chars));
                return;
            }
        }
        // 当元素是按顺序排的，则直接输出
        System.out.println(line);
    }

}
