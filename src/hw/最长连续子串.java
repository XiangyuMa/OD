package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 11:45
 */
public class 最长连续子串 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            String[] split = line.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++){
                list.add(Integer.parseInt(split[i]));
            }
            int count = -1;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) == num) {
                    count = Math.max(1,count);
                } else if (list.get(i) < num) {
                    int sum = 0;
                    int start = i;
                    while (start < list.size()){
                        sum += list.get(start);
                        if (sum == num) {
                            count = Math.max(count, start+1-i);
                            break;
                        } else if (sum > num){
                            break;
                        } else {
                            start++;
                        }
                    }
                }
            }
            System.out.println(count);
        }


}
