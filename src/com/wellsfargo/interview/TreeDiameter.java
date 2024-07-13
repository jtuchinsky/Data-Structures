package com.wellsfargo.interview;

public class TreeDiameter {
    class Node {
        Node left, right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public int diameter(Node root){
        int[] diameter = {Integer.MIN_VALUE};
        diameterHelper(root, diameter);
        return diameter[0];
    }

    int diameterHelper(Node node, int[] diameter){
        if(node == null){
            return 0;
        }
        int left = 1 + diameterHelper(node.left, diameter);
        int right = 1 + diameterHelper(node.right, diameter);
        int max = Integer.max(right, left);
        diameter[0] = Integer.max(left+right, diameter[0]);
        return max;
    }

}
