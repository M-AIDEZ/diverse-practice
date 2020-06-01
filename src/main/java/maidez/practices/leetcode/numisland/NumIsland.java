package maidez.practices.leetcode.numisland;

public class NumIsland {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] travelled = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0'|| travelled[i][j] == 1) {
                    continue;
                }
                dfs(grid, i, j, travelled);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int[][] travelled) {
        if (grid[i][j] == '0' || travelled[i][j] == 1) {
            return;
        }
        travelled[i][j] = 1;
        if (i > 0) dfs(grid, i - 1, j, travelled);
        if (i < grid.length - 1) dfs(grid, i + 1, j, travelled);
        if (j > 0) dfs(grid, i, j - 1, travelled);
        if (j < grid[0].length - 1) dfs(grid, i, j + 1, travelled);
    }

    public static void main(String[] args) {
        NumIsland numIsland = new NumIsland();
        numIsland.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
    }
}
