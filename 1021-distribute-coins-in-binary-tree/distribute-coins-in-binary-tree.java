
class Solution {
    public int helper(TreeNode root,int[] count){
        if(root==null) return 0;
        int leftReq = helper(root.left,count);
        int rightReq = helper(root.right,count);
        count[0] += Math.abs(root.val+leftReq+rightReq-1);
        return root.val+leftReq+rightReq-1;
    }
    public int distributeCoins(TreeNode root) {
        int[] count = new int[1];
        helper(root,count);
        return count[0];
    }
}