package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/22 10:56
 * @version: 1.0
 */
public class HExist {

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean ans = false;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return ans;
    }

    boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited){
        if (idx >= word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if (board[i][j] != word.charAt(idx) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean v1 = dfs(board, word, i, j + 1, idx + 1, visited);
        boolean v2 = dfs(board, word, i + 1, j, idx + 1, visited);
        boolean v3 = dfs(board, word, i - 1, j, idx + 1, visited);
        boolean v4 = dfs(board, word, i, j - 1, idx + 1, visited);
        visited[i][j] = false;
        return v1 || v2 || v3 || v4;
    }

    public static void main(String[] args) {
        char[][] array = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        new HExist().exist(array, "ABCB");
    }
}
