package dfs;

import java.util.Scanner;

/**
 * @author :马翔宇
 * @description 岛屿的数量
 * @date: 2022/11/23 15:52
 */
public class LeetCode200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++nums;
                    dfs(grid, r, c);
                }
            }
        }
        return nums;
    }
}
