package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 16:00
 */
public class CPU最少执行时间 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // CPU最少执行时间
    public static void test005() {
        Scanner sc = new Scanner(System.in);
        // 每秒执行任务数
        int qps = Integer.parseInt(sc.nextLine());
        int arrayLen = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        int[] array = new int[arrayLen];
        String[] strings = line.split(" ");
        for (int i = 0; i < arrayLen; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        // 使用的时间
        int time = 0;
        // 剩余任务，初始为0
        int leaveTask = 0;
        for (int i = 0; i < arrayLen; i++) {
            // 若当前任务+剩余任务大于每秒执行任务，则剩余任务 = 之前剩余任务 + 当前任务 - 每秒执行任务
            if (array[i] + leaveTask > qps) {
                leaveTask = array[i] + leaveTask - qps;
            } else {
                leaveTask = 0;
            }
            // 累加时间
            time++;
        }
        // 当数组走完后还有剩余任务，用剩余任务/每秒执行任务算出需要的时间
        if (leaveTask > 0) {
            int res = leaveTask / qps;
            time = time + res;
            if (leaveTask % qps != 0) {
                time++;
            }
        }
        System.out.println(time);
    }

}
