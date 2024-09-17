package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :马翔宇
 * @description:排序规则默认从小到大，且数字比字母的ascll小
 * @date: 2024/9/17 16:55
 */
public class ZY2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("E");
        list.add("A");
        list.add("1");
        list.add("9");
        list.add("F");
        list.add("a");
        Collections.sort(list,null);
        int k = 'A';
        System.out.println("k=" + k);
        list.stream().forEach(s -> System.out.println(s));
    }
}
