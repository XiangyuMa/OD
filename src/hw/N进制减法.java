package hw;

import java.util.Scanner;

public class N进制减法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int jin = Integer.parseInt(input[0]);
        String numStr = input[1];
        String jianStr = input[2];
        //检查开头
        if (numStr.length() != 1 && jianStr.length() != 1 && (numStr.startsWith("0") || jianStr.startsWith("0"))){
            System.out.println(-1);
            return;
        }
        //检查结尾
        if (numStr.endsWith("/0")){
            numStr = numStr.substring(0,numStr.length()-2);
        }
        if (jianStr.endsWith("/0")){
            jianStr = jianStr.substring(0,jianStr.length()-2);
        }
        int no1 = 0;
        int no2 = 0;
        try {
            no1 = Integer.parseInt(numStr, jin);
            no2 = Integer.parseInt(jianStr, jin);
        }catch (Exception e){
            System.out.println(-1);
            return;
        }

        int res = no1 - no2;
        if (no1 - no2 > 0){
            System.out.print(0+" ");
        }else {
            System.out.print(1+" ");
        }
        System.out.println(Integer.toString(res, jin));
    }
}
