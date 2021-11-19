package com.leet.problems;

public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
    }

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        return 1 + minDepth(root.left);

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
