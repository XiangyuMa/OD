package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/3 23:11
 */
public class 字符串解压缩 {
    public static void main(String[] args) {
        test();
    }
    // hw.字符串解压缩
    // 解题思路：遍历每个字符，取出字符前的数字进行解压缩
    public static void test(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 替换掉合法字符
        String replaceAll = line.replaceAll("[1-9]|[a-z]", "");
        // 替换掉合法字符后，长度不为0，则不合法 || 最后一个字符是数字，不合法
        if (replaceAll.length() > 0 || Character.isDigit(line.charAt(line.length() - 1))) {
            System.out.println("!error");
            return;
        }
        // 存放结果
        String resLine = line;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // 获取字符前的数字
            if (Character.isDigit(c)){
                int start = i;
                while (Character.isDigit(line.charAt(i+1))){
                    i++;
                }
                int num = Integer.parseInt(line.substring(start, i+1));
                // 2不需要压缩，不合法
                if (num <= 2) {
                    System.out.println("!error");
                    return;
                }
                resLine = "";
                for(int k = 0;k<num;k++){
                    resLine += line.charAt(i+1);
                }
                resLine += line.substring(i+2,line.length());
            }
        }
        System.out.println(resLine);
    }

}
