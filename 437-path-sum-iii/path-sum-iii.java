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
        DFS Approach:
        =============
        1. Use pathSum method to visit each node as a starting point for nodes.
        2. Do dfs to check all possible values from the current node
        3. Increment the total counter if a path's  sum matches the target.
    */
   int total = 0;
   public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        dfs(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return total;
    }

    void dfs(TreeNode root, int sum, long curr) {
        if (root == null) {
            return;
        } 

        curr += root.val;
        if (curr == sum) {
            total++;
        }

        dfs(root.left, sum, curr);
        dfs(root.right, sum, curr);
    }
}