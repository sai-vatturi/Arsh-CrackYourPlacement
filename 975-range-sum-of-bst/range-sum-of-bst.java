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
        1. Traverse through the list and check if the value is between low and high
        2. if it's low, add it to the sum variable else traverse
        3. return the sum value
    */
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        findRangeSum(root, low, high);
        return sum;
    }

    public void findRangeSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        findRangeSum(root.left, low, high);
        findRangeSum(root.right, low, high);
    }
}