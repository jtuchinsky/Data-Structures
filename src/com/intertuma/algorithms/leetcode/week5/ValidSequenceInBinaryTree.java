package com.intertuma.algorithms.leetcode.week5;

import org.junit.Test;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation
 * of all values of the nodes along a path results in a sequence in the given binary tree.
 */
public class ValidSequenceInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }

    boolean helper(TreeNode node, int[] arr, int pos){
        if(node.val != arr[pos])
            return false;

        if(pos == arr.length - 1)
            return node.left == null && node.right == null;

        boolean left = false;
        if(node.left != null)
            left = helper(node.left, arr, pos+1);
        boolean right = false;
        if(node.right != null)
            right = helper(node.right, arr, pos+1);
        return left || right;
    }

    @Test
    public void isValidSequence(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.left.left.right = new TreeNode(1);

        System.out.println(isValidSequence(root, new int[] {0,1,0,1}));
    }


}
