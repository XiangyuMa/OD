package hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:58
 */
public class 删除出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    //删除出现次数最少的字符
    public static void test19(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line.length() <= 1) {
            System.out.println("empty");
            return;
        }

        char[] chars = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        Integer[] array = new Integer[map.size()];
        Integer[] array1 = map.values().toArray(array);
        Arrays.sort(array1);
        int minLen = array1[0];
        for (Character s : map.keySet()) {
            if (map.get(s) == minLen) {
                line = line.replace(s + "", "");
            }
        }
        if (line.length() <= 0) {
            System.out.println("empty");
        } else {
            System.out.println(line);
        }
    }

}
