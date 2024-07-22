class Solution {
    public void setZeroes(int[][] matrix) {
        // brute: create matrix replica and use original matrix to find 0's and replace SC:O(NM)
        // optimal: create two arrays for rows and cols and mark -1 if there are zeroes anywhere. then run through the original matrix again and make zeros SC:O(N + M)
        // best: O(1)
        // 1. embed the extra col and row in 1st col and row of matrix
        // 2. take an extra variable for accompanying the 1st row value 
        // 3. make 1st row and col 0's if there exists any value with zero
        // 4. at the end, quickly run through again to make zeros
        // Note: run the extraVariable at end because it might interfere
        int extraVariable = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Determine if the first row or first column has any zeros
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                extraVariable = 0;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
            }
        }

        // Step 2: Use first row and column to mark zeros for the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark column
                }
            }
        }

        // Step 3: Set matrix cells to zero based on marks in the first row and column
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set the first row and first column to zero if needed
        if (matrix[0][0] == 0) {
            for (int j = 1; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (extraVariable == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}