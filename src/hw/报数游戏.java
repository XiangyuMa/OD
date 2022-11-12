package hw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class 报数游戏 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= 1 || num>= 100){
            System.out.println("ERROR!");
            return;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i < 101; i++) {
            map.put(i,i);
        }
        int start = 1 ;
        while (map.size() >= num){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer key = next.getKey();
                map.put(key,start++);
                Integer value = next.getValue();
                if (value == num){
                    iterator.remove();
                    start = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> cou : map.entrySet()) {
            sb.append(cou.getKey()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb);
    }
}

