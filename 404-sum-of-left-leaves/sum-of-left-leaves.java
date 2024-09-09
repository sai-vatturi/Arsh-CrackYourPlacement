/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        1. Use a boolean variable called isLeft denoting if its left child or right side view.
        2. if leaf is reached, if it is left add the value to sum, else ignore
    */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        return sumOfLeaves(root, true);
    }

    public int sumOfLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }

        return sumOfLeaves(root.left, true) + sumOfLeaves(root.right, false);
    }
}