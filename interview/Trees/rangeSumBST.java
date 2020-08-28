/*
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive)
The binary search tree is guaranteed to have unique values.

 

Example 1:
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15             10
                                                            5      15
                                                        3     7       18
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10         10
                                                            5       15
                                                        3      7  13    18
                                                    1         6
Output: 23
*/

package interview.Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class rangeSumBST {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(18);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;

        System.out.println(rangeSum(root, 7, 15));

    }

    public static int rangeSum(TreeNode root, int L, int R) {

        helper(root, L, R);
        return count;

    }

    public static void helper(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            count += root.val;
        }
        helper(root.left, L, R);
        helper(root.right, L, R);
    }

}
