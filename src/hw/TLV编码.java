package hw;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 15:44
 */
public class TLV编码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    // 输出信元的值
    public static void test003() {
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();
        String line = sc.nextLine();
        int len = line.length();
        int p = 0;
        while (p < len) {
            // value的长度  后两位拼接前两位，16进制，需要转换为10进制
            int length = Integer.parseInt(line.substring(p + 6, p + 8) + line.substring(p + 3, p + 5), 16);
            // 找到目标值
            if (tag.equals(line.substring(p, p + 2))) {
                String value = line.substring(p + 9, p + 9 + (length * 3 - 1));
                System.out.println(value);
                return;
            }
            // 动态算出p应该移动几位，tag和length是固定的，value根据length决定，要注意空格
            p += 9 + length * 3;
        }
    }

}
