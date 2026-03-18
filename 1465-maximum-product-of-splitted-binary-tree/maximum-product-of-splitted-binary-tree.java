
class Solution {
    // long max=1;
    long mod=1000000007;
    public long helper(long totalSum,TreeNode root,long[] max){
        if(root==null) return 0;
        long curr = (long)root.val+helper(totalSum,root.left,max)+helper(totalSum,root.right,max);
        max[0] = Math.max(max[0],curr*(totalSum-curr));
        return curr;
    }
    public long dfs(TreeNode root){
        if(root==null) return 0;
        return (long)root.val+dfs(root.left)+dfs(root.right);
    }
    public int maxProduct(TreeNode root) {
        long totalSum = dfs(root);
        long[] max = new long[1];
        max[0]=1;
        helper(totalSum,root,max);
        return (int)(max[0]%mod);
    }
}