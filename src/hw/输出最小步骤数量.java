package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 *   // hw.输出最小步骤数量
 *     // 解题思路：遍历符合条件的第一步，拿到第二步的值，判断是否符合要求，不符合则继续，拿到最小的值
 * @date: 2022/11/4 9:55
 */
public class 输出最小步骤数量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++){
            list.add(Integer.parseInt(split[i]));
        }

        // 结果
        int res = Integer.MAX_VALUE;
        // 条件：必须从第一元素起  且 1<=第一步步长<len/2  (len为数组长度)
        for (int i = 1; i <= list.size()/2; i++) {
            int count = 1;
            // 第一步所在位置的值
            Integer nextNum = list.get(i);
            while (true){
                // i + nextNum 是第一次走的长度加当前位置的长度
                // 如果是终点则结束
                if (i + nextNum == list.size() - 1) {
                    count++;
                    break;
                } else if (i + nextNum <= list.size() / 2) { // 第一次后没有过数组一半，肯定不是最优解
                    count = Integer.MAX_VALUE;
                    break;
                } else if (i + nextNum < list.size() - 1) { // 超过数组一半且不到终点
                    // 还没到终点则在向前走当前位置的步数
                    nextNum = nextNum + list.get(i + nextNum);
                    count++;
                } else { // 超过终点则结束
                    count = Integer.MAX_VALUE;
                    break;
                }
            }
            // 取最小值
            res = Math.min(res, count);
        }
        if (res == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

}
