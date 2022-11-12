package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:14
 */
public class 最少停车场 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 最少停车数
    public static void test074() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(",");
        // 连续1的次数
        int count = 0;
        // 找出所有的连续1的次数，存在list中
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            // 找出连续1的次数
            while (i < split.length && "1".equals(split[i])) {
                count++;
                i++;
            }
            // 连续1的次数大于0，存入list中
            if (count != 0) {
                list.add(count);
            }
            // 初始化
            count = 0;
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            // 累加结果，算出能停几辆卡车
            res += list.get(i) / 3;
            // 如果%3有剩余的，则再加一辆，不用管余1还是余2，最小都是一辆
            if (list.get(i) % 3 != 0) {
                res++;
            }
        }
        System.out.println(res);
    }

}
