package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:23
 */
public class 小朋友身高位置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 小朋友身高位置
    public static void test076() {
        Scanner sc = new Scanner(System.in);
        // 数组长度
        int len = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] split = line.split(" ");
        // 双层循环，依次往后比较
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Integer.parseInt(split[i]) < Integer.parseInt(split[j])) {
                    System.out.print(j + " ");
                    break;
                }
                // 当看到最后一个，还没结束，说明没有，输出0
                if (j == len - 1) {
                    System.out.print(0 + " ");
                }
            }
        }
        // 队首直接输出0
        System.out.print(0);
    }

}
