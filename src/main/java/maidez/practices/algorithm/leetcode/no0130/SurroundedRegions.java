package maidez.practices.algorithm.leetcode.no0130;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int[][] travelled = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (travelled[i][j] == 2) {
                    continue;
                }
                if (board[i][j] == 'X') {
                    travelled[i][j] = 2;
                    print(board, travelled);
                    continue;
                }
                boolean closed = dfsValidate(i, j, board, travelled);
                dfsSet(i, j, closed ? 'X' : 'O', board, travelled);
            }
        }
    }

    private boolean dfsValidate(int i, int j, char[][] board, int[][] travelled) {
        travelled[i][j] = 1;
        print(board, travelled);
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) return false;
        return (board[i + 1][j] == 'X' || travelled[i + 1][j] != 0 || dfsValidate(i + 1, j, board, travelled))
                && (board[i - 1][j] == 'X' || travelled[i - 1][j] != 0 || dfsValidate(i - 1, j, board, travelled))
                && (board[i][j + 1] == 'X' || travelled[i][j + 1] != 0 || dfsValidate(i, j + 1, board, travelled))
                && (board[i][j - 1] == 'X' || travelled[i][j - 1] != 0 || dfsValidate(i, j - 1, board, travelled));
    }

    private void dfsSet(int i, int j, char s, char[][] board, int[][] travelled) {
        if (travelled[i][j] != 2) {
            travelled[i][j] = 2;
            print(board, travelled);
        }
        if (s == 'X') {
            board[i][j] = s;
            print(board, travelled);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O' && travelled[i + 1][j] != 2)
            dfsSet(i + 1, j, s, board, travelled);
        if (j + 1 < board[0].length && board[i][j + 1] == 'O' && travelled[i][j + 1] != 2)
            dfsSet(i, j + 1, s, board, travelled);
        if (i - 1 >= 0 && board[i - 1][j] == 'O' && travelled[i - 1][j] != 2)
            dfsSet(i - 1, j, s, board, travelled);
        if (j - 1 >= 0 && board[i][j - 1] == 'O' && travelled[i][j - 1] != 2)
            dfsSet(i, j - 1, s, board, travelled);
    }

    private void print(char[][] board, int[][] travelled) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "(" + (travelled[i][j] == 0 ? " " : travelled[i][j] == 1 ? "V" : "D") + ")" + " ");
            }
            System.out.println(" ");
        }
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}});
    }
}
