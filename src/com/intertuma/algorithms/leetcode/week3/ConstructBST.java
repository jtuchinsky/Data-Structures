package com.intertuma.algorithms.leetcode.week3;

import org.junit.Test;

public class ConstructBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    TreeNode helper(int[] arr, int start, int end){
        if(start > end)
            return null;

        TreeNode root = new TreeNode(arr[start]);
        if(start != end) {
            int rightIndex = start + 1;
            while(rightIndex <= end && arr[rightIndex] < arr[start])
                rightIndex++;

            root.left = helper(arr, start + 1, rightIndex-1);
            root.right = helper(arr, rightIndex, end);
        }

        return root;
    }

    void printTree(TreeNode t){
        if(t == null) {
            //System.out.print(" null ");
            return;
        }

        System.out.print(t.val + " ");
        printTree(t.left);
        printTree(t.right);
    }

    @Test
    public void bstFromPreorder(){
        int[] preorder = {8,5,1,7,10,12};

        printTree(bstFromPreorder(preorder));
    }
}
