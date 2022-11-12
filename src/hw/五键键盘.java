package hw;

import java.util.Scanner;
//hw.五键键盘 Ctrl c ...
public class 五键键盘 {
    private static String screen = "";
    private static String choose = "";
    private static String jianQie = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            operate(Integer.parseInt(input[i]));
        }
        System.out.println(screen.length());
    }

    public static void operate(int num){
        if (num == 1){//a screen输入一个a
            if (choose.equals("")){
                screen += "a";
            }else {
                choose = "";
                screen = "a";
            }
            return;
        }
        if (num == 2){//ctrl-c
            jianQie = choose;
            return;
        }
        if (num == 3){//ctrl-x
            jianQie = choose;
            choose = "";
            screen = "";
            return;
        }
        if (num ==4){//ctrl-v
            if (choose.equals("")){
                screen += jianQie;
            }else {
                screen = jianQie;
                choose = "";
            }
            return;
        }
        if (num == 5){//ctrl-a
            choose = screen;
        }
    }
}
