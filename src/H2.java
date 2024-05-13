import java.util.*;


/**
 * @author :马翔宇
 * @description
 * @date: 2024/5/13 14:24
 */
public class H2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i =0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = new ArrayList<>();
        for(Map.Entry entry: map.entrySet()){
            if((int)entry.getValue() == 1){
                list.add((Character) entry.getKey());
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0;i < list.size();i++){
            String tmp = list.get(i)+"";
            minIndex = Math.min(minIndex, s.indexOf(tmp));
        }
        if (minIndex>= s.length()){
            System.out.println(-1);
        }else {
            System.out.println(s.charAt(minIndex));
        }
    }
}
