package dfs;

import java.util.Scanner;

/**
 * @author :马翔宇
 * dfs解决岛屿问题，
 * 框架代码：
 * void dfs(int[][] grid, int r, int c) {
 *     // 判断 base case
 *     if (!inArea(grid, r, c)) {
 *         return;
 *     }
 *     // 如果这个格子不是岛屿，直接返回
 *     if (grid[r][c] != 1) {
 *         return;
 *     }
 *     grid[r][c] = 2; // 将格子标记为「已遍历过」
 *
 *     // 访问上、下、左、右四个相邻结点
 *     dfs(grid, r - 1, c);
 *     dfs(grid, r + 1, c);
 *     dfs(grid, r, c - 1);
 *     dfs(grid, r, c + 1);
 * }
 *
 * // 判断坐标 (r, c) 是否在网格中
 * boolean inArea(int[][] grid, int r, int c) {
 *     return 0 <= r && r < grid.length
 *         	&& 0 <= c && c < grid[0].length;
 * }
 * @description 给定二维数组中岛屿的最大面积
 * @date: 2022/11/23 15:26
 */
public class LeetCode695 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    int area = area(grid,i,j);
                    res = Math.max(res,area);
                }
            }
        }
        return res;
    }

    public int area(int[][] grid, int i, int j) {
        if(!inArea(grid,i,j)){
            return 0;
        }
        if(grid[i][j] !=1){
            return 0;
        }
        grid[i][j] = 2;
        return 1 + area(grid,i,j-1)
                + area(grid,i+1,j)
                + area(grid,i-1,j)
                + area(grid,i,j+1);

    }

    public boolean inArea(int[][] grid, int i, int j) {
        return i>=0 && i < grid.length && j>=0 && j < grid[0].length;
    }
}
