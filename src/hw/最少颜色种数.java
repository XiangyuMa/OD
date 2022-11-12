package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:39
 */
public class 最少颜色种数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // hw.最少颜色种数
    // 解题思路：维护一个新集合，用于存储不能整除最小数的，遍历输入的数，每个数都去与新集合的每个数比较是否整除，不能整除则加入新数组
    public static void test026(){
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String[] split = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++){
            list.add(Integer.parseInt(split[i]));
        }
        // 对数组进行升序排序
        Collections.sort(list);
        // 存储不能整除最小数的数
        List<Integer> resList = new ArrayList<>();
        // 最少需要1中颜色，所以最小的数是基数
        resList.add(list.get(0));
        for (int i = 1; i < len; i++){
            int num = list.get(i);
            for (int j = 0; j < resList.size(); j++) {
                // 符合条件，则退出
                if (num % resList.get(j) == 0) {
                    break;
                }
                // 到最后一个都不符合条件，则加入不能整除数组
                if (j == resList.size() - 1) {
                    resList.add(num);
                }
            }
        }
        System.out.println(resList.size());

    }

}
