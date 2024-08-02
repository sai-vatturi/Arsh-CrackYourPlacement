class Solution {
    //  Recursively search in all directions from each cell, marking as visited and backtracking if necessary.
    // use visited array to keep track of visited positions
   public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existUtil(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existUtil(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if ((existUtil(board, word, index + 1, i + 1, j, visited) ||
                existUtil(board, word, index + 1, i - 1, j, visited) ||
                existUtil(board, word, index + 1, i, j + 1, visited) ||
                existUtil(board, word, index + 1, i, j - 1, visited))) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}