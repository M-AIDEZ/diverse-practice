package maidez.practices.algorithm.leetcode.findcirclenum;

public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int count = 0;
        int pCnt = M.length;
        int[] travelled = new int[pCnt];
        for (int i = 0; i < pCnt; i++) {
            if (travelled[i] == 1) {
                continue;
            }
            dfs(i, M, travelled);
            count++;
        }
        return count;
    }

    private void dfs(int i, int[][] M, int[] travelled) {
        if (travelled[i] == 1) {
            return;
        }
        travelled[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && i != j) {
                dfs(j, M, travelled);
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        findCircleNum.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}});
    }
}
