package dfs;

/**
 * @author :
 * @description LeetCode79
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @date: 2022/11/15 11:26
 */
public class LeetCode79 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    char[][] board;
    String word;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从word中第一字符开始匹配
                if (backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, int index) {
        // 递归终止条件
        if (index == word.length()) {
            return true;
        }
        //边界
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean found = false;
        for (int[] dir : dirs) {
            //遍历四个反向
            int newRow = row + dir[0], newCol = col + dir[1];
            found = backtrack(newRow, newCol, index + 1);
            if (found) {
                break;
            }
        }
        //回溯
        visited[row][col] = false;
        return found;
    }

}
