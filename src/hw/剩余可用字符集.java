package hw;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 23:04
 */
public class 剩余可用字符集 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 如果全量字符中有重复的，是相加还是取最后一个？？ 我做的是相加，如果取最后一个则先remove，在put，就能保证插入顺序
    // hw.剩余可用字符集
    // 解题思路：使用按插入顺序排列的LinkedHashMap来存储全量字符集，在减掉已用字符集
    public static void test063() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split("@");
        // 一个字符都没被占用
        if (line.charAt(line.length() - 1) == '@') {
            System.out.println(line.substring(0, line.length() - 1));
            return;
        }
        String[] allString = split[0].split(",");
        String[] userString = split[1].split(",");
        // LinkedHashMap 按插入顺序排列
        Map<String, Integer> map = new LinkedHashMap<>();
        // 遍历全量字符串，存进LinkedHashMap中
        for (int i = 0; i < allString.length; i++) {
            String[] strAndNum = allString[i].split(":");
            String str = strAndNum[0];
            int num = Integer.parseInt(strAndNum[1]);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + num);
            } else {
                map.put(str, num);
            }
        }
        // 遍历用过的字符串，在LinkedHashMap中减掉使用的次数
        for (int i = 0; i < userString.length; i++) {
            String[] strAndNum = userString[i].split(":");
            String str = strAndNum[0];
            int num = Integer.parseInt(strAndNum[1]);
            map.put(str, map.get(str) - num);
        }
        // 拼接输出的字符串
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            // 只输出有剩余的字符串
            if (map.get(s) > 0) {
                sb.append(s + ":" + map.get(s) + ",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}
