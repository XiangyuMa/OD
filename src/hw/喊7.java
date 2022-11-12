package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:54
 */
public class 喊7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 喊7
    public static void test(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int length = split.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Integer.parseInt(split[i]);
        }
        List<Integer> list = new ArrayList<>();
        // 求出所有含7以及7的倍数 (k不超过200)
        for (int i = 1; i < 200; i++) {
            String s = i+"";
            if (s.contains("7") || i % 7 == 0) {
                list.add(i);
            }
        }
        int[] array = new int[length];
        for (int i = 0; i < res; i++) {
            array[(list.get(i) % length) - 1] += 1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
