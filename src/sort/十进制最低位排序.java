package sort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description 100%pass
 * @date: 2022/11/4 10:46
 */
public class 十进制最低位排序 {
    public static void main(String[] args) {
       test027();
    }
    // 元素十进制最低位排序
    // 解题思路：取元素最后一位进行比较排序
    public static void test027(){
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        List<String> list = Arrays.asList(split);
        list.sort((s1, s2) -> {
            // 取元素最后一个进行比较排序
            return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append(s + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}
