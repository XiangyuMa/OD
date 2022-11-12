package hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author :马翔宇
 * @description leetcode 20 括号匹配
 * @date: 2022/10/20 16:31
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    public boolean isValid(String s) {
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
