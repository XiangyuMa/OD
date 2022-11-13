package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 16:06
 */
public class 小朋友身高排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 小朋友身高排序
    public static void test006() {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] input1 = line1.split(" ");
        String[] input2 = line2.split(" ");
        // 基准数
        int height = Integer.parseInt(input1[0]);
        // 人数
        int num = Integer.parseInt(input1[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(input2[i]));
        }

        // list.sort() 自定义排序规则
        // 在 list.sort() 底层代码中，以 compare(list [ i - 1 ], list [ i ]) 形式调用该方法，
        // 当其的返回值大于0时，list [ i - 1 ] 将与 list [ i ] 交换位置
        list.sort((h1, h2) -> {
            // 与基准数的绝对值
            int diff1 = Math.abs(h1 - height);
            int diff2 = Math.abs(h2 - height);
            // 若与基准数的绝对值相等，则高的排在后，否则基准数大的排在后
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });
        for (Integer h : list) {
            System.out.print(h + " ");
        }
    }

}
