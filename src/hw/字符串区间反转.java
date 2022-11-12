package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 16:07
 */
public class 字符串区间反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 字符串翻转
    public static void test007() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();
        // 去掉前后的空格
        line = line.trim();
        String[] split = line.split(" ");
        // 如果起始数小于0，取0
        start = Math.max(start, 0);
        // 如果结束数大于数组长度，取数组最后一个
        end = Math.min(end, split.length - 1);
        // 指定反转区间只有一个单词，或无有效单词则统一输出EMPTY
        if (start >= end || start >= split.length - 1 || end <= 0) {
            System.out.println("EMPTY");
            return;
        }
        // 进行字符串翻转，直至重合
        while (start < end){
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s + " ");
        }
        // 去掉末尾的空格
        System.out.println(sb.toString().trim());
    }

}
