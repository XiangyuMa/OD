package honor;

import java.util.*;

/**
 * @author :马翔宇
 * @description:
 * 给定一个正数数组arr，arr的累加和代表金条的总长度，arr的每个数代表金条要分成的长度。
 * 规定长度为k的金条分成两块，费用为k个铜板。返回把金条分出arr中的每个数字需要的最小代价。
 * @date: 2024/5/9 16:09
 */
public class H1002035 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < m;i++){
            arr[i] = scanner.nextInt();
            list.add(arr[i]);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        queue.addAll(list);
        int price = 0;
        if(!queue.isEmpty() && queue.size() ==1){
            price = queue.poll();
        }
        while (queue.size() >=2){
            int one = queue.poll();
            int another = queue.poll();
            price += one + another;
            queue.offer(one + another);
        }
        System.out.println(price);
        scanner.close();
    }
}
