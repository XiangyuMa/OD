package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 12:31
 */
public class 树根节点到最小叶子节点的路径 {
    public static void main(String[] args) {
        test011();
    }
    // 解题思路：找出除了根节点的最小节点，除以2得到的整数就是它的父节点，依次除下去，直至根节点
    // 树根节点到最小的叶子节点的路径
    public static void test011(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] s = line.split(" ");
        // 只输入一个根元素，直接返回
        if(s.length <= 1) {
            System.out.println(s[0]);
            return;
        }
        List<Integer> list = new ArrayList<>();
        // 集合第一个元素是无关元素，存个最大的整型数
        list.add(Integer.MAX_VALUE);
        for (int i = 0;i<s.length;i++) {
            list.add(Integer.parseInt(s[i]));
        }
        // 找出最小的数，-1表示该节点为空，不参与查找
        int res = Integer.MAX_VALUE;
        for (int i = 2;i<list.size();i++) {
            if (list.get(i) != -1) {
                res = Math.min(res, list.get(i));
            }
        }
        // 找不到最小的数，说明树除了根元素，其他都是-1
        if (res == Integer.MAX_VALUE) {
            System.out.println(s[0]);
            return;
        }
        // 找出最小的数所在位置
        int resKey = 0;
        for (int i = 2;i<list.size();i++) {
            if (list.get(i) == res) {
                resKey = i;
            }
        }
        // 用于储存结果
        List<Integer> resList = new ArrayList<>();
        while (resKey != 1) {
            resList.add(resKey);
            resKey = resKey / 2;
        }
        // 添加根元素
        resList.add(1);
        for (int i = resList.size() - 1; i >= 0;i--) {
            System.out.print(list.get(resList.get(i)) + " ");
        }
    }

}
