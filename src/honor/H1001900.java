package honor;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description: 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序
 * 要求 空间复杂度O(1)
 * @date: 2024/5/9 18:32
 *
 * 三指针：
 * 使用三个指针：left, index, right 分别表示 a[0…left] 为 0 ，a[left+1…index] 为 1，a[right…n-1] 为 2。枚举 index ，分情况处理：
 *
 * 若 a[index] == 0 ，说明其应该划分到左边，交换 a[index] 和 a[++left]，因为 a[++left] 位置一定为 2 ，所以交换后 index++；
 * 若 a[index] == 2 ，说明其应该划分到右边，交换 a[index] 和 a[–right]，因为不知道 a[–right] 的值，所以 index 不改变；
 * 否则的话，index++，直到 index == right，中间部分和右边部分对接成功，停止。
 * 
 */
public class H1001900 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i = 0;i < m;i++){
            arr[i] = scanner.nextInt();
        }
        sort(arr);
        for (Integer i:arr) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    private static void sort(int[] arr) {
        int l = -1,r = arr.length,index = 0;
        while(index < r){
            if(arr[index] == 1) {
                index++;
            } else if (arr[index] == 0) {
                swap(arr,++l,index++);
            }else {
                swap(arr,--r,index);
            }
        }
    }
    private static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
