package sort;

import java.util.*;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:51
 */
public class 最大和最小N个数之和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 最大N个数和最小N个数的和
    // 解题思路：对数组进行去重且排序，当满足条件时取最后两个与最前两个相加
    public static void test028(){
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String[] split = sc.nextLine().split(" ");
        int num = Integer.parseInt(sc.nextLine());
        // 去重且排序
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            set.add(Integer.parseInt(split[i]));
        }
        // 去重后长度不是num的两倍
        if (set.size() < 2 * num) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        // 将set转为list
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < num; i++) {
            sum += list.get(i) + list.get(list.size() - 1 - i);
        }
        System.out.println(sum);
    }

}
