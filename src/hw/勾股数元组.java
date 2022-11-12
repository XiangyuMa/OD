package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 15:32
 */
public class 勾股数元组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 解题思路：双层for循环，求出所有勾股数元组，在筛选出符合条件的
    // 勾股数元组
    public static void test001() {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        boolean flag = true;
        for (int i = num1; i < num2; i++) {
            for (int j = i + 1; j <= num2; j++) {
                // pow()：取几次方，0.5次方相当于开根号
                double res = Math.pow(i, 2) + Math.pow(j, 2);
                double pow = Math.pow(res, 0.5);
                // 结果小于nums且是整数    判断一个double型数据是不是整数：Math.abs(pow - Math.round(pow)) < Double.MIN_VALUE
                if (pow <= num2 && Math.abs(pow - Math.round(pow)) < Double.MIN_VALUE) {
                    int powRes = (int) pow;
                    // 两两互质
                    if (isSingle(i, j) && isSingle(i, powRes) && isSingle(j, powRes)) {
                        System.out.println(i + " " + j + " " + powRes);
                        flag = false;
                    }
                }
            }
        }
        if (flag) {
            System.out.println("Na");
        }
    }

    /**
     * 判断两个数字是否互质 （没有相同的公约数）
     *
     * @param num1
     * @param num2
     * @return
     */
    private static boolean isSingle(int num1, int num2) {
        int res = Math.min(num1, num2);
        for (int i = 2; i <= res; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }
        return true;
    }

}
