class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int ans = -1;
        while(!q.isEmpty()){
            int len = q.size();
            int minIdx = (int)(1e9);
            int maxIdx = -(int)(1e9);
            for(int k=0;k<len;k++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int idx = p.idx;
                minIdx = Math.min(minIdx,idx);
                maxIdx = Math.max(maxIdx,idx);
                int currIdx = idx - minIdx;
                if(node.left!=null){
                    q.add(new Pair(node.left,2*currIdx+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*currIdx+2));
                }
            }
            ans = Math.max(ans,maxIdx-minIdx+1);
        }
        return ans;
    }
}