package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 22:03
 */
// 最长元音字符串
// 解题思路：定义一个元音字符数组，判断字符是否在数组中，且是连续的，定义一个临时长度来记录连续且元音字符长度，保留最长的
public class MaxLengthYuanyinString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void test066() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        // 最大长度
        int maxLen = 0;
        // 临时长度
        int tempLen = 0;
        for (int i = 0; i < chars.length; i++) {
            // 元音且连续
            while (i < chars.length && list.contains(chars[i])) {
                i++;
                tempLen++;
            }
            // 保留最长串
            maxLen = Math.max(maxLen, tempLen);
            // 初始化
            tempLen = 0;
        }
        System.out.println(maxLen);
    }

}
