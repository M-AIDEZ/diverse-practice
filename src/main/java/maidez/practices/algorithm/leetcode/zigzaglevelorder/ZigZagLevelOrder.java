package maidez.practices.algorithm.leetcode.zigzaglevelorder;

import java.util.*;

public class ZigZagLevelOrder {

    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public int maximalSquare(char[][] matrix) {
        int maxSideLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int maxij;
                    if (i == 0 || j == 0)
                        maxij = matrix[i][j] - '0';
                    else
                        maxij = Math.max(matrix[i - 1][j - 1] - '0', Math.max(matrix[i][j - 1] - '0', matrix[i - 1][j] - '0')) + 1;

                    matrix[i][j] = (char) maxij;
                    maxSideLength = Math.max(maxSideLength, maxij);
                }

            }
        }
        return maxSideLength * maxSideLength;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        queue.add(root);
        while (!queue.isEmpty() || !stack.isEmpty()) {
            List<Integer> queueInteger = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                queueInteger.add(poll.val);

                if (poll.left != null) {
                    if (poll.left.left != null) queue.add(poll.left.left);
                    if (poll.left.right != null) queue.add(poll.left.right);
                    stack.push(poll.left);
                }

                if (poll.right != null) {
                    if (poll.right.left != null) queue.add(poll.right.left);
                    if (poll.right.right != null) queue.add(poll.right.right);
                    stack.push(poll.right);
                }
            }
            if (!queueInteger.isEmpty()) resultList.add(queueInteger);

            List<Integer> stackInteger = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                stackInteger.add(pop.val);
            }
            if (!stackInteger.isEmpty()) resultList.add(stackInteger);
        }
        return resultList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
