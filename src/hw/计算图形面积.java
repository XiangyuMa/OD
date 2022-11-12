package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 23:01
 */
// 这个通过率好像只有95%，没有具体的测试数据，我也不知道哪里有问题
// hw.计算图形面积
// 解题思路：每个点的面积等于下一个点x值 - 当前点x值 乘以 当前点y的累计值。最后一个点则是:终点x值 - 当前点x值 乘以 当前点y的累计值
public class 计算图形面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void test064() {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] split1 = line1.split(" ");
        int num = Integer.parseInt(split1[0]);
        int end = Integer.parseInt(split1[1]);
        // 存放x坐标的值
        List<Integer> listX = new ArrayList<>();
        // 存放y坐标的值
        List<Integer> listY = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            listX.add(Integer.parseInt(split[0]));
            listY.add(Integer.parseInt(split[1]));
        }
        // y的累计值
        int sumY = 0;
        // 总面积
        int sumArea = 0;
        for (int i = 0; i < num; i++) {
            // 最后一个点
            if (i == num - 1) {
                // y的累计值
                sumY += listY.get(i);
                // 终点x值 - 当前点x值 乘以 当前点y的累计值
                sumArea += (end - listX.get(i)) * Math.abs(sumY);
            } else {
                // y的累计值
                sumY += listY.get(i);
                // 下一个点x值 - 当前点x值 乘以 当前点y的累计值
                sumArea += (listX.get(i + 1) - listX.get(i)) * Math.abs(sumY);
            }
        }
        System.out.println(sumArea);
    }

}
