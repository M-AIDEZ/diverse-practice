package maidez.practices.algorithm.leetcode.maximalsquare;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }

    public int maximalSquare(char[][] matrix) {
        int maxSideLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int maxij;
                    if (i == 0 || j == 0)
                        maxij = matrix[i][j];
                    else
                        maxij = Math.max(matrix[i - 1][j - 1], Math.max(matrix[i][j - 1], matrix[i - 1][j])) + 1;

                    matrix[i][j] = (char) maxij;
                    maxSideLength = Math.max(maxSideLength, maxij - '0');
                }

            }
        }
        return maxSideLength * maxSideLength;
    }
}


