
class Solution {
    public void helper(TreeNode leftTree,TreeNode rightTree,int level){
        if(leftTree==null || rightTree==null) return;
        if(level%2!=0){
            int temp=leftTree.val;
            leftTree.val=rightTree.val;
            rightTree.val=temp;
        }
        helper(leftTree.left,rightTree.right,level+1);
        helper(leftTree.right,rightTree.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left,root.right,1);
        return root;
    }
}