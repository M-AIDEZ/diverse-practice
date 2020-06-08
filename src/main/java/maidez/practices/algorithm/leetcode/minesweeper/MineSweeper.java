package maidez.practices.algorithm.leetcode.minesweeper;

public class MineSweeper {
    public static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        int aroundMCount = aroundMCount(board, row, col);
        if (aroundMCount == 0) {
            board[row][col] = 'B';
            if (isInBoard(board, row - 1, col - 1) && board[row - 1][col - 1] == 'E')
                updateBoard(board, new int[]{row - 1, col - 1});
            if (isInBoard(board, row - 1, col) && board[row - 1][col] == 'E')
                updateBoard(board, new int[]{row - 1, col});
            if (isInBoard(board, row - 1, col + 1) && board[row - 1][col + 1] == 'E')
                updateBoard(board, new int[]{row - 1, col + 1});
            if (isInBoard(board, row, col - 1) && board[row][col - 1] == 'E')
                updateBoard(board, new int[]{row, col - 1});
            if (isInBoard(board, row, col + 1) && board[row][col + 1] == 'E')
                updateBoard(board, new int[]{row, col + 1});
            if (isInBoard(board, row + 1, col - 1) && board[row + 1][col - 1] == 'E')
                updateBoard(board, new int[]{row + 1, col - 1});
            if (isInBoard(board, row + 1, col) && board[row + 1][col] == 'E')
                updateBoard(board, new int[]{row + 1, col});
            if (isInBoard(board, row + 1, col + 1) && board[row + 1][col + 1] == 'E')
                updateBoard(board, new int[]{row + 1, col + 1});
        } else {
            board[row][col] = (char) (48 + aroundMCount);
        }
        return board;
    }

    private static int aroundMCount(char[][] board, int row, int col) {
        int aroundMCount = 0;
        if (isInBoard(board, row - 1, col - 1) && board[row - 1][col - 1] == 'M')
            aroundMCount++;
        if (isInBoard(board, row - 1, col) && board[row - 1][col] == 'M')
            aroundMCount++;
        if (isInBoard(board, row - 1, col + 1) && board[row - 1][col + 1] == 'M')
            aroundMCount++;
        if (isInBoard(board, row, col - 1) && board[row][col - 1] == 'M')
            aroundMCount++;
        if (isInBoard(board, row, col + 1) && board[row][col + 1] == 'M')
            aroundMCount++;
        if (isInBoard(board, row + 1, col - 1) && board[row + 1][col - 1] == 'M')
            aroundMCount++;
        if (isInBoard(board, row + 1, col) && board[row + 1][col] == 'M')
            aroundMCount++;
        if (isInBoard(board, row + 1, col + 1) && board[row + 1][col + 1] == 'M')
            aroundMCount++;
        return aroundMCount;
    }

    private static boolean isInBoard(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1) {
            return false;
        }
        if (col < 0 || col > board[0].length - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        updateBoard(board, new int[]{3, 0});
        print(board);
    }

    private static void print(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.print("\n");
        }
        System.out.println("========================");
    }
}
