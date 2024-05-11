package honor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author :马翔宇
 * @description:
 * 给定一个整型数组arr，再给定一个整数k，打印所有出现次数大于n/k的数，如果没有这样的数,请打印”-1“。
 * @date: 2024/5/10 14:52
 */
public class H1008914 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int num = scanner.nextInt();
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().filter(kk -> kk.getValue() > n / k).collect(Collectors.toList());
        if(list.size() == 0){
            System.out.println(-1);
        }else {
            for (Map.Entry<Integer,Integer> entry: list) {
                System.out.print(entry.getKey()+ " ");
            }
        }

        scanner.close();
    }
}
