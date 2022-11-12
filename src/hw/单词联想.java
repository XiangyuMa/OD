package hw;

import java.util.*;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:52
 */
public class 单词联想 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // hw.单词联想
    // 解题思路：用正则表达式切分出每个单词，遍历字符，保存满足条件的字符
    public static void test029(){
        Scanner sc = new Scanner(System.in);
        // 正则表达式：\W+ ：匹配一个或多个非字母进行切割，匹配到的非字母不缓存
        String[] split = sc.nextLine().split("\\W+");
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            // 判断目标字符是否是输入字符开头的，且要去重
            if (split[i].startsWith(str) && !list.contains(split[i])) {
                list.add(split[i]);
            }
        }
        // 对list进行排序
        list.sort((s1, s2) -> {
            // 遍历字符串中每个字符，返回第一处不同字符的差值
            return s1.compareTo(s2);
        });

        if (list.size() > 0) {
            for (String s : list) {
                System.out.print(s + " ");
            }
        } else {
            System.out.println(str);
        }
    }

    // hw.单词联想
    public static void test029_2(){
        Scanner sc = new Scanner(System.in);
        //  // 正则表达式：\W+ ：匹配一个或多个非字母进行切割，匹配到的非字母不缓存
        String[] split = sc.nextLine().split("\\W+");
        String str = sc.nextLine();
        // TreeSet 有序的set，英文按字典降序排序
        // 使用TreeSet还可以自动去重
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(str)) {
                set.add(split[i]);
            }
        }
        if (set.size() > 0) {
            for (String s : set) {
                System.out.print(s + " ");
            }
        } else {
            System.out.println(str);
        }
    }

}
