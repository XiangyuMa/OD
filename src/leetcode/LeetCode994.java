package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode994. 腐烂的橘子
 *
 */
public class LeetCode994 {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //新鲜橘子的数量
        int count = 0;
        for(int r = 0;r < m;r++){
            for(int c = 0;c < n;c++){
                if(grid[r][c] == 1){
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r,c});
                }
            }
        }
        int minutes = 0;

        while(count > 0 && !queue.isEmpty()){
            minutes++;
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if(r-1>=0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1,c});
                }
                if(r+1 < m && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }
                if(c-1>=0 && grid[r][c-1] ==1){
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r,c-1});
                }
                if(c+1 < n && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r,c+1});
                }

            }
        }
        if(count > 0){
            return -1;
        }else {
            return minutes;
        }

    }
}
