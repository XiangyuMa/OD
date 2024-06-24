package onecar;

public class Test {
    public static void main(String[] args) {
/*        String s1 = "coder";
        String s2 = "coder";
        String s3 = "coder" + s2;
        String s4 = "coder" + "coder";
        String s5 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == "codercoder");*/
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3==s4);
        //总结：
        /**
         * 常量与常量的拼接结果在常量池，原理是编译期优化
         *
         * 常量池中不会存在相同内容的变量
         *
         * 只要其中有一个是变量，结果就在堆中。变量拼接的原理是StringBuilder
         *
         * 如果拼接的结果调用intern()方法，则主动将常量池中还没有的字符串对象放入池中，并返回此对象地址
         */

    }
}
