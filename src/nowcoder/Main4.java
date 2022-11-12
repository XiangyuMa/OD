package nowcoder;

import java.util.Scanner;

/**
 * HJ76
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：
 * 6
 * 输出：
 * 31+33+35+37+39+41
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 1;i<= Math.pow(n,3);i+=2){
            int k = i;
            for(int j =1;j<=n;j++){
                sum += k;
                k+=2;
            }
            if(sum == Math.pow(n,3)){
                for(int t =i;t<k-2;t+=2){
                    System.out.print(t +"+");
                }
                System.out.println(k-2);
                return;
            }
            sum = 0;
        }
        scanner.close();
    }
}
