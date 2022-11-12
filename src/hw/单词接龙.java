package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:26
 */
public class 单词接龙 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // PS：如果给出的单词中同样的单词出现两次，能用两次还是用一次？我这里是用了两次，如果只能用一次的话，可以用一个list来存储用过的单词，如果在里面，就不用
    // 单词接龙
    public static void test055_2() {
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int len = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(sc.nextLine());
        }
        String startWord = list.get(start);
        // 移除起始元素
        list.remove(startWord);
        list.sort((s1, s2) -> {
            int length1 = s1.length();
            int length2 = s2.length();
            if (length1 != length2) {
                return length2 - length1;
            }
            // 按照字典排序，遍历每一个字符，返回不相同字符的差值
            return s1.compareTo(s2);
        });
        String result = startWord;
        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);
            if (getStartOrEnd(startWord, 100).equals(getStartOrEnd(value, 1))) {
                result = result + value;
                // 找到的单词作为起始单词
                startWord = value;
                // 移除用过的单词
                list.remove(value);
                // 找到了归零，下一个从头开始找
                i = 0;
            }
        }
        System.out.println(result);
    }

    private static String getStartOrEnd(String key, int num) {
        // 求字符串首字母
        if (num == 1) {
            return key.substring(0, 1);
        } else { // 求字符串尾字幕
            return key.substring(key.length() - 1, key.length());
        }
    }

}
