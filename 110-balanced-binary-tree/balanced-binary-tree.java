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
        Brute Force Solution:
        =====================
        1. For every node, find the height of the left sub tree, find the height of the right sub tree.
        2. if difference b/w left subtree and right subtree is <= 1 return true, else false

        Optimal Approach:
        =================
        1. Instead of calculating height again and again for every node in the tree, calculate the difference while calaculating the height itself.
        2. Change the height logic for a binary tree to calculate and check difference of height and return true or false accordingly.
    */
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        if (leftHeight == -1) return -1; 

        int rightHeight = findHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; 
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }



    /*
    Brute Approach:
    ================
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    */
}