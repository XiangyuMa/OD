package hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 10:26
 */
public class 多个数组按顺序取出固定长度成为新数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 从多个数组中按顺序取出固定长度的内容组成新数组
    // 解题思路：在循环内遍历每个数组，将符合长度要求的数放进新数组，当新数组长度 == 多个数组长度之和时，循环结束
    public static void test022(){
        Scanner sc = new Scanner(System.in);
        // 每次切割长度
        int num = Integer.parseInt(sc.nextLine());
        // 数组数量
        int acount = Integer.parseInt(sc.nextLine());
        List<List<String>> list = new ArrayList<>();
        // 全部数组总长度
        int sumLen = 0;
        for (int i = 0; i < acount; i++) {
            List<String> e = Arrays.asList(sc.nextLine().split(","));
            sumLen += e.size();
            list.add(e);
        }
        // 存放结果
        List<String> resList = new ArrayList<>();
        int index = 0;
        // 当结果数组长度 大于等于 全部数组总长度 时，运算结束退出循环
        while (resList.size() < sumLen) {
            // 遍历每个数组
            for (int i = 0; i < acount; i++) {
                List<String> list1 = list.get(i);
                if (index > list1.size()) { // 数组用完了，退出此次循环
                    continue;
                } else if (index + num < list1.size()){ // 数组元素还充足
                    for (int j = index; j < index + num; j++) {
                        resList.add(list1.get(j));
                    }
                } else { // 来到最后，取数组剩余元素
                    for (int j = index; j < list1.size(); j++) {
                        resList.add(list1.get(j));
                    }
                }
            }
            // 更换起点
            index += num;
        }
        for (int i = 0; i < resList.size(); i++){
            if (i == resList.size() - 1) {
                System.out.print(resList.get(i));
            }else {
                System.out.print(resList.get(i) + ",");
            }
        }
    }

}
