class Pair{
    TreeNode first;
    int second;
    Pair(TreeNode first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void preorder(HashMap<TreeNode,TreeNode> map,TreeNode root){
        if(root==null) return;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        preorder(map,root.left);
        preorder(map,root.right);
    }
    public TreeNode find(TreeNode root, int start){
    if(root == null) return null;
    if(root.val == start) return root;

    TreeNode left = find(root.left, start);
    if(left != null) return left;

    return find(root.right, start);
}
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        preorder(map,root);
        Queue<Pair> q = new LinkedList<>();
        TreeNode st = find(root, start);
        q.add(new Pair(st,0));
        Set<TreeNode> vis = new HashSet<>();
        vis.add(st);
        int maxi=-1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.first;
            int min = p.second;
            maxi = min;
            if(node.left!=null && !vis.contains(node.left)){
                vis.add(node.left);
                q.add(new Pair(node.left,min+1));
            }
            if(node.right!=null && !vis.contains(node.right)){
                vis.add(node.right);
                q.add(new Pair(node.right,min+1));
            }
            if(map.get(node)!=null && !vis.contains(map.get(node))){
                vis.add(map.get(node));
                q.add(new Pair(map.get(node),min+1));
            }
        }
        return maxi;
    }
}