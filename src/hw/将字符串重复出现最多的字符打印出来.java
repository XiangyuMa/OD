package hw;

import java.util.HashMap;
import java.util.Map;

public class 将字符串重复出现最多的字符打印出来 {
    public static void main(String[] args) {
        String input  = "aasdfrsdgdede";
        System.out.println(getNumberOfCharacters(input));
    }

    public	static	Map<Character,Integer>	getNumberOfCharacters(String	str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //直接输出字符以及出现的个数
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("字符是" + entry.getKey() + "出现的次数是" + entry.getValue());
        }
        return map;
    }
}
