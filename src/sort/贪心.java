package sort;

import java.util.Arrays;
import java.util.Comparator;

public class 贪心 {
    public static void main(String[] args) {

    }

    /**
     * 区间重叠
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        //按照区间结束节点值升序
        Arrays.sort(intervals,new Comparator<int[]>(){
                        @Override
                        public int compare(int[] o1, int[] o2) {

                            return o1[1] - o2[1];
                        }
                    });
        int count  = 1;
        int x_end = intervals[0][1];
        for(int[] interval : intervals){
            int start = interval[0];
            if(start>= x_end){
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }


}
