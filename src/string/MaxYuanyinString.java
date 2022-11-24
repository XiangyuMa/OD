package string;
/**
 * @author :马翔宇
 * @description OD技术二面
 * @date: 2022/11/24 15:26
 */
/**
 * 题目描述
 * 定义：当一个字符串只有元音字母（aeiouAEIOU）组成，称为元音字符串。
 * 现给定一个字符串，请找出其中最长的元音字符子串，并返回其长度；如果找不到，则返回0。
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 解答要求时间限制：1000ms, 内存限制：256MB
 * 输入
 * 一个字符串，其长度范围： 0 < length <= 65535。
 * 字符串仅由字符a-z和A-Z组成。
 * 输出
 * 一个整数，表示最长的元音字符子串的长度。
 * 样例
 * 输入样例 1 复制
 * asdbuiodevauufgh
 * 输出样例 1
 * 3
 * 提示样例 1
 * 最长元音子串为 “uio” 或 “auu”，其长度都为3，因此输出3
 */
public class MaxYuanyinString {
    public static void main(String[] args) {
       String s = "auustauioo";
        System.out.println(fun(s));
    }
    public  static int  fun(String s){
        int max = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i+1;j <= s.length();j++){
                String temp = s.substring(i,j);
                if(isYuanString(temp)){
                    max = Math.max(max,temp.length());
                }
            }
        }
        return max;
    }
    public static  boolean isYuanString(String s){
        for(int i = 0;i < s.length();i++){
            if(!isYuanChar(s.charAt(i))){
                return  false;
            }
        }
        return true;
    }
    public static boolean isYuanChar(char c){
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;

        }
    }
}
