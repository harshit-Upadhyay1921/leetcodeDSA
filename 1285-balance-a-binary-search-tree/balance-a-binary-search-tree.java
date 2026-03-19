
class Solution {
    public void helper(TreeNode root,List<Integer> inorder){
        if(root==null) return;
        helper(root.left,inorder);
        inorder.add(root.val);
        helper(root.right,inorder);
    }
    public TreeNode construct(List<Integer> inorder,int l,int r){
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = construct(inorder,l,mid-1);
        root.right = construct(inorder,mid+1,r);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        helper(root,inorder);
        TreeNode ans = construct(inorder,0,inorder.size()-1);
        return ans;
    }
}