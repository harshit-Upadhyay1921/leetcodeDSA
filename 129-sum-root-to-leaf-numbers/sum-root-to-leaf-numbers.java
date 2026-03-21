
class Solution {
    public void helper(TreeNode root,int path,int[] sum){
        if(root==null) return;
        if(root.left==null && root.right==null){
            path = 10*path+root.val;
            sum[0]+=path;
        }
        path = 10*path + root.val;
        helper(root.left,path,sum);
        helper(root.right,path,sum);

    }
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        helper(root,0,sum);
        return sum[0];
    }
}