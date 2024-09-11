package test;

import java.util.Arrays;

/**
 * @author :马翔宇
 * @description
 * 百度二面
 * @date: 2024/9/10 18:18
 */
public class Main2 {

    //add(1)
    //output()  -> 1
    //add(2) ->2 -1
    //add(3) -> 3 2 1
    //add(4) -> 4 3 2 1
    //add(5) ->5 4 3 2 1

    //add(6) -> 6 5 4 3 2
    //add(3) -> 3 6 5 4 2
    private  int size = 5;

    private int[] table = new int[size];

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        //test
        main2.add(1);
        main2.output();
        main2.add(2);
        main2.output();
        main2.add(3);
        main2.output();
        main2.add(4);
        main2.output();
        main2.add(5);
        main2.output();
        main2.add(6);
        main2.output();
        main2.add(3);
        main2.output();
    }

    public void output() {
        for(int i = 0;i < table.length;i++){
            if(table[i]!=0){
                System.out.print(table[i] + " ");
            }
        }
        System.out.println();
    }
    public int add(int num){
        String s = Arrays.toString(table);
        String tmp = num + "";
        if(tmp.indexOf(s) == -1){
            for(int i=table.length-1;i>=1;i--){
                table[i] = table[i-1];
            }
        }else {
            int index = tmp.indexOf(s);
            for(int i=index;i>=1;i--){
                table[i] = table[i-1];
            }
        }
        table[0] = num;
        return 0;
    }
}
