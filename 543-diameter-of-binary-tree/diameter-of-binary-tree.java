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
    public int height(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 0;
        int maxi=-1;
        int diameter = -1;
        if(root.left!=null && root.right!=null) diameter = 2 + height(root.left)+height(root.right);
        else if(root.left==null || root.right==null) diameter = 1 + height(root.left)+height(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        maxi = Math.max(diameter,Math.max(left,right));
        return maxi;
    }
}