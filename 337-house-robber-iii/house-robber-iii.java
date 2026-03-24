
class Solution {
    public int[] helper(TreeNode root){
        if(root==null) return new int[2];

        int[] leftChoices = helper(root.left);
        int[] rightChoices = helper(root.right);

        int option1 = root.val + leftChoices[1] + rightChoices[1];
        int option2 = Math.max(leftChoices[0],leftChoices[1]) + Math.max(rightChoices[0],rightChoices[1]);
        int[] ans = new int[2];
        ans[0] = option1;
        ans[1] = option2;
        return ans;
    }
    public int rob(TreeNode root) {
        int[] options = helper(root);
        return Math.max(options[0],options[1]);
    }
}