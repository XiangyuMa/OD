package hw;

import java.util.*;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 16:11
 */
public class 寻找重复字符 {
    public static void main(String[] args) {
//       test009();
        test0010();
    }
    // 寻找重复字符
    public static void test009() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        List<Character> list = new ArrayList<>();
        // 将输入的字符串转为字符数组
        for (int i = 0; i < line2.length(); i++) {
            list.add(line2.charAt(i));
        }
        // 用来存第一第二次输入都有的字符
        List<Character> resList = new ArrayList<>();
        for (int i = 0; i < line1.length(); i++) {
            char c = line1.charAt(i);
            // &&后的条件是防止重复
            if (list.contains(c) && !resList.contains(c)) {
                resList.add(c);
            }
        }
        // 对集合进行排序，默认是按ASCII码值排序
        Collections.sort(resList);
        for (Character c : resList) {
            System.out.print(c);
        }
    }

    //treeset 自动去重并完成字典排序
    public static void test0010() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        TreeSet<Character> set = new TreeSet<>();

        for(int i=0;i<line1.length();i++){
            if(line2.contains(line1.charAt(i)+"")){
                set.add(line1.charAt(i));
            }
        }
        for(Character c:set){
            System.out.print(c);
        }
    }

}
