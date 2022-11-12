package hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:38
 */
public class 字母多条件排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // PS：这道题按我的理解我做的是对的，先按次数排序，排完在按a~z A~Z排序。但是案例给的不清楚，或许可以 a~z中按次数排序，后在A~Z中按次数排序，就是小写在前，大写在后
    // 字母多条件排序
    public static void test073() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        // 用一个map，key存字符，value存字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 小写字符的ACSII码大于大写字符， a~z 递增  A~Z递增
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        // 排序  排序规则：当返回的数字大于0，则进行换位置，否则不换
        entries.stream().sorted((s1, s2) -> {
            // 按次数排序
            if (s1.getValue() - s2.getValue() != 0) {
                return s2.getValue() - s1.getValue();
            }
            Character key1 = s1.getKey();
            Character key2 = s2.getKey();
            // a~z 两个小写字母之间的比较
            if (key1.compareTo('A') > 25 && key2.compareTo('A') > 25) {
                return key1 - key2;  // 字符a~z  A~Z之间加减返回数字
            }
            // A~Z 两个大写字母之间的比较
            if (key1.compareTo('A') < 26 && key2.compareTo('A') < 26) {
                return key1 - key2;
            }
            // a~z 混 A~Z  大小写字母之间的比较，大写在后
            return -(key1 - key2);
        }).forEach((s) -> {
            System.out.print(s.getKey() + ":" + s.getValue() + ";");
        });
    }

}
