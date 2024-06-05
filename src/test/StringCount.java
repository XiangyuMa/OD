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
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                //升序
                return  o1.getValue() -o2.getValue();
                //降序
                //return  o2.getValue() -o1.getValue();
            }
        });
        for (Map.Entry<Character,Integer> entry:list){
            System.out.println("字符" + entry.getKey() +"出现" + entry.getValue() +"次");
        }
    }
}
