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
    int maxLevel = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        // list.add(root.val);
        rightView(root, 1, list);
        return list;
    }
    
    void rightView(TreeNode root, int level, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            list.add(root.val);
            maxLevel = level;
        }
        rightView(root.right, level + 1, list);
        rightView(root.left, level + 1, list);
    }
}
