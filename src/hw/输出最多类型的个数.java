package hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 12:40
 */
public class 输出最多类型的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // ps：这道题我的理解是把输入的转为16进制，从后往前取依次取2位，如果16进制数长度大于8，取后8位，然后转为10进制相加，与基数取模。它的案列给得不清楚，不确定题目是不是这个意思。
    // hw.输出最多类型的个数
    public static void test010() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        // 转为int型集合
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        // map用来存储出现次数，key为取模后的值，value为次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i < list.size(); i++) {
            // 将输入的数转为16进制
            String num16 = tenTo16(list.get(i));
            int len = num16.length();
            // 累加的和
            int allRes = 0;
            // 从后往前取依次取2位，如果16进制数长度大于8，取后8位，然后转为10进制相加
            if (len >= 8) {
                // 16进制转10进制：Integer.parseInt("ABCD", 16);
                allRes = Integer.parseInt(num16.substring(len - 8, len - 6), 16) + Integer.parseInt(num16.substring(len - 6, len - 4), 16)
                        + Integer.parseInt(num16.substring(len - 4, len - 2), 16) + Integer.parseInt(num16.substring(len - 2, len), 16);
            } else if (len == 7) {
                allRes = Integer.parseInt(num16.substring(0, 1), 16) + Integer.parseInt(num16.substring(1, 3), 16)
                        + Integer.parseInt(num16.substring(3, 5), 16) + Integer.parseInt(num16.substring(5, 7), 16);
            } else if (len == 6) {
                allRes = Integer.parseInt(num16.substring(0, 2), 16) + Integer.parseInt(num16.substring(2, 4), 16)
                        + Integer.parseInt(num16.substring(4, 6), 16);
            } else if (len == 5) {
                allRes = Integer.parseInt(num16.substring(0, 1), 16) + Integer.parseInt(num16.substring(1, 3), 16)
                        + Integer.parseInt(num16.substring(3, 5), 16);
            } else if (len == 4) {
                allRes = Integer.parseInt(num16.substring(0, 2), 16) + Integer.parseInt(num16.substring(2, 4), 16);
            } else if (len == 3) {
                allRes = Integer.parseInt(num16.substring(0, 1), 16) + Integer.parseInt(num16.substring(1, 3), 16);
            } else if (len == 2) {
                allRes = Integer.parseInt(num16.substring(0, 2), 16);
            } else if (len == 1) {
                allRes = Integer.parseInt(num16.substring(0, 1), 16);
            }
            System.out.println(allRes);
            int modeValue = allRes % list.get(1);
            System.out.println(modeValue);
            // 用map存次数
            if (modeValue < list.get(0)) {
                if (map.containsKey(modeValue)) {
                    map.put(modeValue, map.get(modeValue) + 1);
                } else {
                    map.put(modeValue, 1);
                }
            }
        }
        int maxCount = 0;
        // 找出最大的次数
        for (Integer key : map.keySet()) {
            maxCount = Math.max(map.get(key), maxCount);
        }
        System.out.println(maxCount);
    }

    /**
     * 十进制转十六进制
     *
     * @return
     */
    private static String tenTo16(int num) {
        String s = "";
        do {
            int res = num % 16;
            num = num / 16;
            if (res == 15) {
                s = "F" + s;
            } else if (res == 14) {
                s = "E" + s;
            } else if (res == 13) {
                s = "D" + s;
            } else if (res == 12) {
                s = "C" + s;
            } else if (res == 11) {
                s = "B" + s;
            } else if (res == 10) {
                s = "A" + s;
            } else {
                s = res + s;
            }
        } while (num != 0);
        return s;
    }

}
