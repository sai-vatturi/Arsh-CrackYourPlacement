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
    // do pre-order traversal and if you find any root that is even, check if it has a grandchilden and yes, add to sum value
    // we need the sum to be passed by reference, hence we can have a static variable, or we can pass a one length array

    static int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) {
                    sum += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                    sum += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                    sum += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                    sum += root.right.right.val;
            }
        }
        helper(root.left);
        helper(root.right);
    }
}