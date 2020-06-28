package maidez.practices.algorithm.leetcode.buildtree;

public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    public TreeNode buildTree(int[] preorder, int preStart,
                              int[] inorder, int inStart,
                              int length) {
        if (length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inorderRootIndex = 0;
        for (int i = inStart; i <= length + inStart - 1; i++) {
            if (inorder[i] == preorder[preStart]) {
                inorderRootIndex = i;
                break;
            }
        }
        int leftLength = inorderRootIndex - inStart;
        int rightLength = length - leftLength - 1;
        node.left = buildTree(preorder, preStart + 1, inorder, inStart, leftLength);
        node.right = buildTree(preorder, preStart + 1 + leftLength, inorder, inorderRootIndex + 1, rightLength);
        return node;
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
