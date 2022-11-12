package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 22:16
 */
// 字母所在字符串中的位置索引
// 解题思路：将字符串转为集合，对集合进行排序，找到指定位置的值，在字符串中找该字符所在位置索引
public class MainString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        int index = sc.nextInt();
        int length = chars.length;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(chars[i]);
        }
        // 对集合进行排序
        Collections.sort(list);
        // 大于字符长度
        if (index > length) {
            // 输出排序后最后一个字符所在字符串的索引位置
            System.out.println(line.indexOf(list.get(length - 1)));
        } else {
            // 输出指定位置字符所在字符串的索引位置
            System.out.println(line.indexOf(list.get(index - 1)));
        }
    }

}
