package od;

/**
 * @author :马翔宇
 * @description: od技术一面
 * 面试官问对哪种排序熟悉 答：冒泡、选择、插入、快排，为了简单直接写了一个冒泡排序
 * @date: 2022/11/16 16:30
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] num = new int[]{32,4,2,31,1,3,45,674,567};
        sort(num);
    }
    public static void sort(int[] num) {
        for(int i = 0;i < num.length-1;i++){
            for(int j = 0;j < num.length-1-i;j++) {
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        for(int i = 0;i < num.length;i++){
            System.out.println(num[i]);
        }
    }
}
