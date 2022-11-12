package nowcoder;

import java.util.Scanner;

/**
 * 最大公共子串的长度
 * HJ75
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1\le s\le 150\1≤s≤150
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 *  ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 *
 * 示例1
 * 输入：
 * asdfas
 * werasdfaswer
 * 输出：
 * 6
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss1 = scanner.nextLine();
        String ss2 = scanner.nextLine();

        //s1 是短字符串 s2是长字符串
        String s1 = ss1.length() < ss2.length() ? ss1:ss2;
        String s2 = ss1.length() < ss2.length() ? ss2:ss1;

        //双指针法
        int result = 0;
        for(int i = 0;i < s1.length();i++){
            for (int j = s1.length();j > i;j--){
                if(s2.contains(s1.substring(i,j))){
                    result = j -i > result ? j-i: result;
                }
            }
        }
        System.out.println(result);
        System.out.println("------------------------------");
        method(s1,s2);
        scanner.close();
    }

    //方法2 通过动态规划
    public static  void method(String s1,String s2){
        int maxStr = 0;
        int[][] dp = new int[s1.length()+1][s2.length()+2];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (maxStr < dp[i][j]) maxStr = dp[i][j];
                }
            }
        }
        System.out.println(maxStr);
    }
}
