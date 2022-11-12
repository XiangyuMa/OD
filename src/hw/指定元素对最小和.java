package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 15:41
 */
public class 指定元素对最小和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 指定元素对最小和
    // 思路：双层for循环，求出两个数组所有值一一相加的值，放进另一个数组中，并进行升序排序，求出指定前几个的和
    public static void test002() {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        int[] array1 = stringToArray(line1);
        int[] array2 = stringToArray(line2);
        int len1 = array1.length;
        int len2 = array2.length;
        int groupCount = sc.nextInt();
        List<Integer> list = new ArrayList();
        // 双层for循环，求出两个数组所有值一一相加的值，放进另一个数组中
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                list.add(array1[i] + array2[j]);
            }
        }
        // 对集合进行排序（升序）
        Collections.sort(list);
        int res = 0;
        // 求出指定前几个的和
        for (int i = 0; i < groupCount; i++) {
            res += list.get(i);
        }
        System.out.println(res);
    }
    private static int[] stringToArray(String line) {
        String[] strings = line.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }

}
