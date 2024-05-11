package honor;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author :马翔宇
 * @description:
 * 括号字符串的最长有效长度 | 时间限制：2秒 | 内存限制：262144K
 * 给定一个括号字符串str，返回最长的能够完全正确匹配括号字符字串的长度。
 * @date: 2024/5/9 14:46
 */
public class H1008873 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getMaxStringLength(s));
        scanner.close();
    }

    private static int getMaxStringLength(String s) {
        int max = 0;
        for(int i = 0;i < s.length()-1;i++) {
            for(int j = i+1;j < s.length() + 1;j++){
                String subString = s.substring(i,j);
                if (isMatched(subString)){
                    max = Math.max(max,subString.length());
                }
            }
        }
        return max;
    }

    private static boolean isMatched(String s) {
        if (s.length() % 2 ==1 ){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) =='(' || s.charAt(i) =='[' ||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else {
                if(stack.empty()){
                    return false;
                } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.peek() =='[') {
                    stack.pop();
                } else if (s.charAt(i) == '}' && stack.peek() =='{') {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
