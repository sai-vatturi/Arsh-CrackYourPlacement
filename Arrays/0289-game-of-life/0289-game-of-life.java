class Solution {
    // Look below for the brute force solution, in a similar way, we will do this in-place
    // Instead of using a whole new matrix, we encode the values in the matrix itself.
    // Even though there are 4 rules, we are majorily concened over 1. live to dead 2. dead to live
    // we encode dead as -1 and living as 2 esentially handling the case and using abs to retrieve the old value
    // in the end, we simply update -1 as dead(0) and 2 as live(1)
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = board[i][j];
                int ones = 0;

                for (int k = 0; k < dx.length; k++) {
                    int pos_x = i + dx[k];
                    int pos_y = j + dy[k];
                    if (pos_x >= 0 && pos_x < m && pos_y >= 0 && pos_y < n) {
                        if (Math.abs(board[pos_x][pos_y]) == 1) ones++;
                    }
                }

                if (value == 1 && (ones < 2 || ones > 3)) {
                    board[i][j] = -1; // live to dead
                } else if (value == 0 && ones == 3) {
                    board[i][j] = 2;  // dead to live
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; // was live, now dead
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; // was dead, now live
                }
            }
        }
    }
}
    // Brute force solution
    /*
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] clone = new int[m][n];

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = board[i][j];
                int ones = 0;

                for (int k = 0; k < dx.length; k++) {
                    int pos_x = i + dx[k];
                    int pos_y = j + dy[k];
                    if (pos_x >= 0 && pos_x < m && pos_y >= 0 && pos_y < n) {
                        if (board[pos_x][pos_y] == 1) ones++;
                    }
                }
                System.out.print(ones + " ");
                if (value == 1 && ones < 2) {
                    clone[i][j] = 0;
                } else if (value == 1 && ones >= 2 && ones <= 3) {
                    clone[i][j] = 1;
                } else if (value == 1 && ones > 3) {
                    clone[i][j] = 0;
                } else if (value == 0 && ones == 3) {
                    clone[i][j] = 1;
                } else {
                    clone[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = clone[i][j];
            }
        }
    }
    */
