package nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :马翔宇
 * @description: 删除字符串中出现次数最少的字符 且原来的顺序不变
 * @date: 2024/2/26 22:42
 */
public class Main11 {
    public static void main(String[] args) {
        String s = "abbcdd";
        System.out.println(Main11.getString(s));
    }
    public static String getString(String s) {
        int min = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            Character tmp = s.charAt(i);
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
            min = Math.min(min,map.get(tmp));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            Character tmp = s.charAt(i);
            if(map.get(tmp)!= min){
                stringBuilder.append(tmp);
            }
        }
        return stringBuilder.toString();
    }
}
