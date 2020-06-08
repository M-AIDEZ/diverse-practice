package maidez.practices.algorithm.leetcode.maxareaofisland;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] tripped = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (tripped[i][j] == 1) {
                    continue;
                }
                max = Math.max(max, trip(i, j, grid, tripped));
            }
        }
        return max;
    }

    private int trip(int i, int j, int[][] grid, int[][] tripped) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0) {
            return 0;
        }
        if (tripped[i][j] == 1) {
            return 0;
        }
        tripped[i][j] = 1;
        if (grid[i][j] == 0) {
            return 0;
        } else {
            return 1
                    + trip(i - 1, j, grid, tripped)
                    + trip(i + 1, j, grid, tripped)
                    + trip(i, j - 1, grid, tripped)
                    + trip(i, j + 1, grid, tripped);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}});
    }
}
