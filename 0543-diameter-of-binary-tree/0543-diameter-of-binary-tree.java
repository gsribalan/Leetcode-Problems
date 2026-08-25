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
    int diameter;
    public int dfs_diameter(TreeNode root){
        if(root==null)return 0;
        int left=dfs_diameter(root.left);
        int right=dfs_diameter(root.right);
        this.diameter=Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs_diameter(root);
        return this.diameter;
    }
}