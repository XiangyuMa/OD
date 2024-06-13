package test;

import java.util.*;

/**
 * 自定义排序规则
 */
public class StringCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i < str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0) + 1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        for(Map.Entry entry :map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Character,Integer> entry:list){
            System.out.println("字符" + entry.getKey() +"出现" + entry.getValue() +"次");
        }
    }
}
