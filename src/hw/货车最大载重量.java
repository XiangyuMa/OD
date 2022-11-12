package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 14:02
 */
public class 货车最大载重量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 货车最大载货量
    public static void test012() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int capacity = sc.nextInt();
        String[] split = line.split(",");
        // 将字符串数组转为Integer型集合
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        // 对集合进行排序
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (sum + list.get(i) < capacity) {
                sum = sum + list.get(i);
            } else {
                System.out.println(i);
                return;
            }
        }
    }

}
