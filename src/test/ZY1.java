package test;

/**
 * @author :马翔宇
 * 招商银行机考编程题二
 * @description：给定一个数组，代表一个物理的力值，从数组中找一个支点，
 * 使得左边力矩之和与右边力矩之和相等。力矩是数组元素值与支点的乘积，
 * 能找到返回支点位置（支点从0开始），找不到返回-1
 * @date: 2024/9/17 16:55
 */
public class ZY1 {
    public static void main(String[] args) {
        int[] arr = {3,5,1,5,2};
        ZY1 one = new ZY1();
        System.out.println(one.findBalanceFulcrum(arr));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param lever int整型一维数组
     * @return int整型
     */
    public int findBalanceFulcrum (int[] lever) {
        int leftSum = 0,rightSum = 0;
        for(int i = 0;i < lever.length ;i++){
            for(int j = 0;j <i;j++){
                leftSum += lever[j]*(i-j);
            }
            for(int k=i+1;k<= lever.length-1;k++){
                rightSum += lever[k] * (k-i);
            }
            if(leftSum == rightSum){
                return i-1;
            }
        }
        return -1;
    }
}
