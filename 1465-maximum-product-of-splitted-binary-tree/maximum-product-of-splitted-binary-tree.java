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
    static final int MOD = 1000000007;
    List<Long> list = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long totalSum = helper(root);
        long maxSum = 0;
        for(long i: list){
            maxSum = Math.max(maxSum, i*(totalSum-i));
        }

        return (int)(maxSum%MOD);
    }

    long helper(TreeNode root){
        if(root == null) return 0;    
        long left = helper(root.left);
        long right = helper(root.right);

        long sum = left+right+root.val;
        list.add(sum);

        return sum;
    }
}