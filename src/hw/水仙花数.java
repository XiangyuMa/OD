package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:44
 */
public class 水仙花数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 水仙花数
    public static void test070() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n < 3 || n > 7) {
            System.out.println(-1);
            return;
        }
        // 起始数
        int start = (int) Math.pow(10, n - 1);
        // 终止数
        int end = (int) Math.pow(10, n);
        List<Integer> reslist = new ArrayList<>();
        for (int i = start; i < end; i++) {
            int sum = 0;
            // 求每位数的简单解法
            // String[] split = (i + "").split("");
            // for (String s : split) {
            //     sum += Math.pow(Integer.parseInt(s), n);
            // }
            // 算出每位数
            List<Integer> list1 = singleNum(i);
            for (Integer s : list1) {
                // 每位数进行n次方并累加
                sum += Math.pow(s, n);
            }
            // 满足要求的放进结果集中
            if (sum == i) {
                reslist.add(i);
            }
        }
        if (m >= reslist.size()) {
            System.out.println(reslist.get(reslist.size() - 1) * m);
        } else {
            System.out.println(reslist.get(m));
        }
    }

    /**
     * 将一个整型数从后往前输出单个数字
     * @param num
     * @return
     */
    public static List<Integer> singleNum(int num){
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int singleNum  = num % 10;
            list.add(singleNum);
            num = num /10;
        }
        return list;
    }

}
