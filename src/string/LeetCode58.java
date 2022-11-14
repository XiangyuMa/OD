package string;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/14 10:09
 */
public class LeetCode58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();

    }
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
    class Solution {

        // 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
        // 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
        public boolean oneEditAway(String first, String second) {
            int m = first.length(), n = second.length();
            if (n - m == 1) {
                return oneInsert(first, second);
            } else if (m - n == 1) {
                return oneInsert(second, first);
            } else if (m == n) {
                boolean foundDifference = false;
                for (int i = 0; i < m; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        if (!foundDifference) {
                            foundDifference = true;
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean oneInsert(String shorter, String longer) {
            int length1 = shorter.length(), length2 = longer.length();
            int index1 = 0, index2 = 0;
            while (index1 < length1 && index2 < length2) {
                if (shorter.charAt(index1) == longer.charAt(index2)) {
                    index1++;
                }
                index2++;
                if (index2 - index1 > 1) {
                    return false;
                }
            }
            return true;
        }
    }


}
