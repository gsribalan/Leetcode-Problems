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
    //Set<Integer>res=new LinkedHashSet<>();
    List<Integer>res=new ArrayList<>();
        
    public void dfs_in(TreeNode root){
        if(root==null)return;
        dfs_in(root.left);
        res.add(root.val);
        dfs_in(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs_in(root);
        return res;
    }
}