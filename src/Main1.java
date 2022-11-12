
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/5 13:21
 */
public class Main1 {
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
