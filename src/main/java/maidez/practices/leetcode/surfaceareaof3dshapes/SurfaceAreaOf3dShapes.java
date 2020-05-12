package maidez.practices.leetcode.surfaceareaof3dshapes;

public class SurfaceAreaOf3dShapes {
    public static int surfaceArea(int[][] grid) {
        int n = grid.length;
        int cubeCount = 0;
        int hiddenFaceCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cubeCount += grid[i][j];
                hiddenFaceCount += Math.max(grid[i][j] - 1, 0);
                if (i != n - 1)
                    hiddenFaceCount += Math.min(grid[i][j], grid[i + 1][j]);
                if (j != n - 1)
                    hiddenFaceCount += Math.min(grid[i][j], grid[i][j + 1]);
            }
        }
        return cubeCount * 6 - hiddenFaceCount * 2;
    }
}
