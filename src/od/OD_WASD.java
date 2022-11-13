package od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :OD机试题第一题
 * @description 题目大意：WASD为游戏控制的四个方向，如果一个字符串中WASD各个字符次数相同称之为
 * 完美走位，问改变其中连续的一段字符使得成为完美走位最少要改动字符数
 * @date: 2022/11/5 13:21
 */
public class OD_WASD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int aNum = 0,sNum = 0,dNum = 0,wNum = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i)=='A'){
                aNum++;
            }else if (str.charAt(i)=='S'){
                sNum++;
            }else if (str.charAt(i)=='D'){
                dNum++;
            }else {
                wNum++;
            }
        }
        if(aNum == 1 && sNum==1 && dNum ==1 && wNum ==1){
            System.out.print(0);
        }
        List<Integer> list = new ArrayList<>();
        list.add(aNum);
        list.add(sNum);
        list.add(dNum);
        list.add(wNum);
        Collections.sort(list);

        System.out.println(list);
        System.out.println((list.get(list.size()-1) - list.get(0)/2));
        int m = str.length() / 4 ;
        int min = Math.min(Math.abs(m-aNum),Math.abs(m-sNum));
        int min2 = Math.min(Math.abs(m-dNum),Math.abs(m-wNum));
        System.out.println( Math.min(min,min2) );

        scanner.close();

    }
}
