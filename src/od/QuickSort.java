package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * 快速排序
 * @date: 2022/11/24 10:11
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        int[] arr = {3,1,5,2,99,20,78,4,7,9,11};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(value -> System.out.println(value));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if(left < right){
            int index = partition(arr,left,right);
            quickSort(arr,left,index-1);
            quickSort(arr,index+1,right);
        }
        return arr;
    }

    /**
     * 确定基准元素的位置
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for(int i = index;i <= right;i++){
            // 将小于基准元素的数放在数组左边
            if(arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        //交换此时数组基准元素磨人的位置和世实际应该的位置
        swap(arr,pivot,index - 1);
        return index - 1;
    }

    /**
     * 交换数组中下表的元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
