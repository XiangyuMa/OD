package nowcoder;

import java.util.Scanner;

/**
 * HJ81
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:1\le len(S),len(T)\le200\1≤len(S),len(T)≤200
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 * 示例1
 * 输入：
 * bc
 * abc
 * 输出：
 * true
 * 说明：
 * 其中abc含有bc，输出"true"
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if (s1.length() > s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        for(int i = 0;i < s1.length();i++){
            if(!s2.contains(s1.charAt(i)+"")){
                System.out.printf("false");
                return;
            }
        }
        System.out.print("true");
        scanner.close();
    }
}
