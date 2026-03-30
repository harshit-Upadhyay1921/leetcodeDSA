class Pair {
    TreeNode node;
    int dis;
    Pair(TreeNode node,int dis){
        this.node = node;
        this.dis = dis;
    }
}
class Solution {
    public void constructMap(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null) return;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        constructMap(root.left,map);
        constructMap(root.right,map);
    }
    public TreeNode findNode(TreeNode root,TreeNode target){
        if(root==null) return null;
        if(root.val==target.val) return root;
        TreeNode leftFind = findNode(root.left,target);
        if(leftFind!=null && leftFind.val==target.val) return leftFind;
        return findNode(root.right,target);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        constructMap(root,map);
        TreeNode startNode = findNode(root,target);
        System.out.println(startNode.val);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode,0));
        Set<Integer> st = new HashSet<>();

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int dis = p.dis;
            st.add(node.val);
            if(dis==k) list.add(node.val);
            if(map.get(node)!=null && !st.contains(map.get(node).val)){
                q.add(new Pair(map.get(node),dis+1));
            }
            if(node.left!=null && !st.contains(node.left.val)) q.add(new Pair(node.left,dis+1));
            if(node.right!=null && !st.contains(node.right.val)) q.add(new Pair(node.right,dis+1));
        }
        return list;
    }
}