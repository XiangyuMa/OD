package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:20
 */
public class 最优组合策略 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // hw.最优组合策略
    // 解题思路：遍历每一个数组，找到最小值，记录最小值的索引，相邻的数组不使用上次记录的索引所在的值
    public static void fun(){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            list.add(sc.nextLine());
        }
        // 结果
        int sum = 0;
        // 存储最终最小值的索引
        int minIndex = 1111;
        for (int i = 0; i < num; i++){
            String[] split = list.get(i).split(" ");
            // 用来存储临时的最小值的索引
            int tempIndex = 9999;
            // 默认最小值
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < split.length; j++){
                int temp = Integer.parseInt(split[j]);
                // 最小的 且 不与相邻的用户使用相同的调度策略
                if (temp <= minNum && j != minIndex) {
                    minNum = temp;
                    tempIndex = j;
                }
            }
            sum += minNum;
            // 上一个数组最小值的位置
            minIndex = tempIndex;
        }
        System.out.println(sum);
    }

}
