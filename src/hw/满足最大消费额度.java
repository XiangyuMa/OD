package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:18
 */
public class 满足最大消费额度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 满足最大消费额度
    public static void test077() {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] split = line1.split(",");
        int len = split.length;
        int sum = 0;
        // 依次遍历，列出所有的三数之和
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int res = Integer.parseInt(split[i]) + Integer.parseInt(split[j]) + Integer.parseInt(split[k]);
                    if (res < Integer.parseInt(line2)) {
                        // 与原来的值比较，留下大的值
                        sum = Math.max(sum, res);
                    }
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
        }
    }

}
