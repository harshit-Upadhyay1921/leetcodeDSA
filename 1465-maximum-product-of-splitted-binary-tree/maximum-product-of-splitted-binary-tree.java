
class Solution {
    long max=1;
    long mod=1000000007;
    public long helper(long totalSum,TreeNode root){
        if(root==null) return 0;
        long curr = (long)root.val+helper(totalSum,root.left)+helper(totalSum,root.right);
        max = Math.max(max,curr*(totalSum-curr));
        return curr;
    }
    public long dfs(TreeNode root){
        if(root==null) return 0;
        return (long)root.val+dfs(root.left)+dfs(root.right);
    }
    public int maxProduct(TreeNode root) {
        long totalSum = dfs(root);
        helper(totalSum,root);
        return (int)(max%mod);
    }
}