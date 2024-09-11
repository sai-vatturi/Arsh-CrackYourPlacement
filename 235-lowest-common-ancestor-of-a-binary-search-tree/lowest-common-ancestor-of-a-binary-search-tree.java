/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
        Brute Force Approach:
        ====================
        1. DFS once for finding the node p, and save the path in an array
        2. DFS second time for finding the node q and save the path in an array
        3. Compare both the arrays and check the last visited path by both and return it

        Optimal Appraoach using Recursion:
        =================================
        1. Check if the root node is one of p and q. if yes, return the root node.
        2. Now check for the left and right tree. Now look at the below conditions
            -- if Root found, return that root to its parent
            -- if Root Not found, check for the right part
            -- if root is not found in both left and right, return the node itself
            -- if one of the root is found, return that root to its parent
        3. Do a dry run for better understanding
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }   
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }
}
