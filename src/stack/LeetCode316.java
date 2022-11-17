package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author :马翔宇
 * @description：
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @date: 2022/11/17 17:57
 */
public class LeetCode316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(removeDuplicateLetters(s));
        scanner.close();
    }
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // 记录字符串中字符的数量
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        // 判断某个字符是否出现过
        boolean[] exist = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (exist[c]) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                exist[stack.pop()] = false;
            }
            stack.push(c);
            exist[c] = true;
        }

        //字母顺序pop后是反的 所以要反转一下
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
