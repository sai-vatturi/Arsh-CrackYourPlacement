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
        1. Do Depth First Search along with a StringBuilder object
        2. if Reached null, add it to the paths array
        3. Keep track of the length of the StringBuilder before we append anything to it before recursion and afterwards set the length back.
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getPaths(root, paths, new StringBuilder());
        return paths;
    }

    public void getPaths(TreeNode root, List<String> paths, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            getPaths(root.left, paths, sb);
            getPaths(root.right, paths, sb);
        }
        sb.setLength(len);
    }   
}