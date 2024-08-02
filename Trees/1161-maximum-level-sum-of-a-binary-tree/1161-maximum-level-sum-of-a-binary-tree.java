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
    public int maxLevelSum(TreeNode root) {
        // We can basically do a level order traversal and calculate the sum value
        // we can have a variable maxSum, level such that we can save the current min level and maxSum at every depth of the tree

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int levelCount = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int sum = 0;
            levelCount++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                sum += current.val;

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            if (sum > maxSum) {
                level = levelCount;
                maxSum = sum;
            }

        }

        return level;
    }
}