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
    Its just a simple logic, don't confuse

    1. for a root node to be lca, it should contain one left or right or itself as p or q
    2. first we will check if the current root is p or q, if true then we no need to go below because this is the first time we visited this node and it must be the root
    3. if it is not, we will define two nodes left and right, they will do the same thing check if it is the top most node
    4. at last, to accomodate one left or right is null, we write conditions
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
    
}