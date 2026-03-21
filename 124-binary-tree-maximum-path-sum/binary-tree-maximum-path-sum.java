
class Solution {
    public int helper(TreeNode root,int[] maxSum){
        if(root==null) return 0;
        maxSum[0] = Math.max(root.val,maxSum[0]);
        int leftSum = Math.max(0,helper(root.left,maxSum));
        int rightSum = Math.max(0,helper(root.right,maxSum));
        int currSum = root.val + Math.max(leftSum,rightSum);
        int currMaxPathSum = root.val+leftSum+rightSum;
        maxSum[0] = Math.max(maxSum[0],Math.max(currSum,currMaxPathSum));
        return currSum;
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = -(int)(1e9);
        helper(root,maxSum);
        return maxSum[0];
    }
}