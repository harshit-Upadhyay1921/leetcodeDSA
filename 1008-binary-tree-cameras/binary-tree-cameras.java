
class Solution {
    public int helper(TreeNode root,int[] count){
        if(root==null) return 1;
        if(root.left==null && root.right==null) return -1;
        int leftTree = helper(root.left,count);
        int rightTree = helper(root.right,count);
        if(leftTree==-1 || rightTree==-1){
            count[0]++;
            return 0;
        }
        else if(leftTree==0 || rightTree==0){
            return 1;
        }
        else if(leftTree==1 && rightTree==1){
            return -1;
        }
        else{
            return 1;
        }
    }
    public int minCameraCover(TreeNode root) {
        if(root.left==null && root.right==null) return 1;
        int[] count = new int[1];
        int ans = helper(root,count);
        if(ans==-1) return count[0]+1;
        return count[0];
    }
}