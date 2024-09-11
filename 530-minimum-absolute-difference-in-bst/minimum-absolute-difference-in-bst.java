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
        Recursion Approach:
        ==================
        1. The question is same as finding the minimum difference between elements in a sorted array
        2. For representing the tree as sorted array, we can just do inorder traversal
        3. Do inorder traversal while getting the min absolute difference between the current variable and prev visited variable and update the min.
        4. Return min value at the end
    */
    
    int prev = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }

        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;

        if (root.right != null) {
            inOrder(root.right);
        }
    }
}