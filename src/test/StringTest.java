package test;


/**
 * @author :马翔宇
 * @description
 * @date: 2024/3/27 14:37
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = "abc" + s1 + "def";
        String s4 = "abcabcdef";
        System.out.println(s3 == s4);

        String s5 = s3.intern();
        System.out.println(s4 == s5);
    }
}
