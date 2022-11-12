package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 17:50
 */
public class 消除相邻且相同的字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // PS:字符串中的<两个>字母如果相邻且相同,就可以消除,相同的字符只能两两删除，比如有3个只能删2个
    // 消除相邻且相同字母
    public static void test069() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // replaceAll 可以用正则表达式； [a-zA-Z]:匹配a-zA-Z其中一个
        //String newLine = line.replaceAll("[a-z]|[A-Z]", "");
        String newLine = line.replaceAll("[a-zA-Z]", "");
        // 异常输入
        if (newLine.length() > 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < line.length() - 1; i++){
            if (line.charAt(i) == line.charAt(i+1)) {
                // 两个字符相等，则消除
                line = line.replaceFirst(line.substring(i, i+2), "");
                // 需要把指针回到前一个字符
                if (i == 0){
                    i = i - 1; // 因为是开头，只需要-1抵消后面的i++
                } else {
                    i = i - 2; // -1回退到前一个字符，再-1抵消后面的i++
                }
            }
        }
        System.out.println(line.length());

    }

}
