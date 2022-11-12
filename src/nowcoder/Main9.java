package nowcoder;

import java.util.Scanner;

/**
 * HJ100 等差数列求和
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int first = 2,last = 3*n -1;
        System.out.println(n*(first + last)/2);
        scanner.close();
    }
}
