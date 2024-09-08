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
        // Use Recursion to creates nodes from the leaf node and keep adding them to create the tree
        // so basically in this question we have to convert sorted array to height balanced tree
        // if we directly create tree in given sorted order it will become linked list
        // we have to take middle element as head value such it will become height balanced tree
        // assign the value for left of subtree that is l to mid -1 for given array
        // assign the value for right go subtree that is mid+1 to r for given array
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) { 
            return null;
        }
        
        int mid = l + (r - l) / 2; 
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBST(nums, l, mid - 1); 
        root.right = CreateBST(nums, mid + 1, r); 

        return root;
    }
}