package leetcode;

import java.util.Stack;

/**
 * leetcode 150 逆波兰式求值 栈
 */
public class LeetCode150 {
    public static void main(String[] args) {
        String[]  tokens  = new String[]{"4","3","-"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < tokens.length;i++){
            String  c = tokens[i];
            if(isNum(c)){
                stack.push(Integer.valueOf(c));
            } else if ("+".equals(c)) {
               int right =  stack.pop();
               int left = stack.pop();
               stack.push(right+left);
            } else if ("*".equals(c)) {
                int right =  stack.pop();
                int left = stack.pop();
                stack.push(right*left);
            } else if ("-".equals(c)) {
                int right =  stack.pop();
                int left = stack.pop();
                stack.push(left-right);
            } else if ("/".equals(c)) {
                int right =  stack.pop();
                int left = stack.pop();
                stack.push(left/right);
            }

        }
        return stack.peek();
    }
    public static boolean isNum(String s){
        for(int i = 0;i <s.length();i++){
            if(s.charAt(0)=='-' && s.length()>1){
                continue;
            }
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
