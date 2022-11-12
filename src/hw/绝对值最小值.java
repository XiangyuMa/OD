package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:33
 */
public class 绝对值最小值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // hw.绝对值最小值
    // 解题思路：双层for循环，遍历出所有组合，记录最小值
    public static void test(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            // 数组中同一个元素不能使用两遍
            if (!list.contains(parseInt)) {
                list.add(parseInt);
            }
        }

        int res = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                int sum = Math.abs(list.get(i) + list.get(j));
                if (sum < res) {
                    a = list.get(i);
                    b = list.get(j);
                    res = sum;
                }
            }
        }
        if (a < b) {
            System.out.println(a + " " + b + " " + res);
        } else {
            System.out.println(b + " " + a + " " + res);
        }
    }

}
