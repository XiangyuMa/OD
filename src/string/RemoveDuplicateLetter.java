package string;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/17 14:17
 */
public class RemoveDuplicateLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));

    }

    /**
     * 去除字符串中的重复字符，使得字典序最小
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new TreeSet<>();
        for(int i = 0;i < s.length();i++){
            set.add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        return stringBuilder.toString();
    }
}
