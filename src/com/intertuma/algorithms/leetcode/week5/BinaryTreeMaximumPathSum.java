package com.intertuma.algorithms.leetcode.week5;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections.
 * <p>
 * The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode node, int[] maxSum) {
        if(node == null)
            return 0;

        int leftSum = maxPathSumHelper(node.left, maxSum);
        int rightSum = maxPathSumHelper(node.right, maxSum);

        int maxExcludingNode = Integer.max(leftSum, rightSum);
        // node.val, node.val + left + right, node.val + maxExcluding
        int maxIncludingNode = Integer.max(
                node.val, Integer.max(
                        node.val + leftSum + rightSum, node.val + maxExcludingNode
                ));

        int max = Integer.max(maxExcludingNode, maxIncludingNode);
        maxSum[0] = Integer.max(maxSum[0], max);
        return Integer.max(node.val, node.val+maxExcludingNode);
    }

}
