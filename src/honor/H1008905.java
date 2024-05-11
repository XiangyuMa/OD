package honor;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description:
 * 在其它数出现次数都为偶数的数组中找到出现次数为奇数次的数 | 时间限制：2秒 | 内存限制：262144K
 * 给一个数组arr，其中只有一个数出现了奇数次，其它数出现了偶数次，打印这个数
 * @date: 2024/5/9 15:30
 */
public class H1008905 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i = 0;i < m;i++){
            arr[i] = scanner.nextInt();
        }
        int odd = 0 ^ arr[0];
        for(int i = 1;i < arr.length;i++){
            odd = arr[i] ^ odd;

        }
        System.out.println(odd);
        scanner.close();
    }
}
