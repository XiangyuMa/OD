package lock;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2023/10/10 17:08
 */
public class ThreadTest {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number2.getTwo();
            }
        }).start();
        number1.getThree();
    }
}
