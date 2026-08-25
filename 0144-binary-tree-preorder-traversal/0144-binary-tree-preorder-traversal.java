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
    List<Integer>res=new ArrayList<>();
    public void dfs_pre(TreeNode root){
        if(root==null)return;
        res.add(root.val);
        dfs_pre(root.left);
        dfs_pre(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs_pre(root);
        return res;
    }
}