package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:43
 */
public class 联系出现第k多的字母 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 输出连续出现次数第k多的字母的次数
    public static void test17() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int num = sc.nextInt();
        char[] chars = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            while (i + 1 < chars.length && c == chars[i + 1]) {
                count++;
                i++;
            }
            if (map.containsKey(c)) {
                if (count > map.get(c)) {
                    map.put(c, count);
                }
            } else {
                map.put(c, count);
            }
            count = 1;
        }
        if (map.size() < num) {
            System.out.println(-1);
            return;
        }
        Object[] array = map.values().toArray();
        Arrays.sort(array, (a1, a2)->{
            return (Integer)a2 - (Integer) a1;
        });

        System.out.println(array[num - 1]);
    }

}
