package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 0:05
 */
public class 相等的连续子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // hw.相等的连续子串
    // 解题思路：双层循环，遍历每个字符，依次判断是否与子串相同，当相同长度与子串相等时，结束并输出；否则进入下一个字符进行判断
    public static void fun() {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String p = sc.nextLine();
        for (int i = 0; i < t.length(); i++) {
            // 开始字符位置
            int start = i;
            // 与子串相同字符个数
            int j = 0;
            // 与子串进行比对
            while (start < t.length() && j < p.length() && t.charAt(start) == p.charAt(j)) {
                // 索引位置向前
                start++;
                // 个数加1
                j++;
            }
            // 当子串相同字符个数 == 子串长度，满足条件，输入并结束
            if (j == p.length()) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("No");
    }

}
