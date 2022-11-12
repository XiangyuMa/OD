package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VLAN资源池 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int search = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("-")){
                String[] num = input[i].split("-");
                int start = Integer.parseInt(num[0]);
                int end = Integer.parseInt(num[1]);
                for (int j = start; j <end+1 ; j++) {
                    list.add(j);
                }
            }else {
                list.add(Integer.parseInt(input[i]));
            }
        }

        Collections.sort(list);
        list.remove((Object) search);
        //输出
        int idx = 0;
        int start = 0;//1 3 4 5
        int tem = 1;
        StringBuffer sb = new StringBuffer();
        while (idx < list.size()){
            if (start == 0){
                start = list.get(idx);
            }
            if (idx+1 == list.size()){//保证下一位一定存在
                sb.append(start);
                break;
            }
            if (list.get(idx+1) == start+tem){//下一位与当前相等 继续后推
                idx ++;
                tem ++;
                continue;
            }else if (start == list.get(idx)){//输出当前值加,
                sb.append(start).append(",");
                start = 0;
                tem = 1;
            }else {
                sb.append(start).append("-").append(list.get(idx));
                start = 0;
                tem = 1;
                if (idx +1 < list.size()){//当前不是最后一个数据
                    sb.append(",");
                }
            }
            idx ++;
        }
        System.out.println(sb);
    }
}

