
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse=false;
        int c=0;
        // List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            // ans.add(list);
            if(c%2==0){
                if(list.get(0)%2==0) return false;
                for(int i=0;i<list.size()-1;i++){
                    if(list.get(i)%2==0 || list.get(i+1)%2==0) return false;
                    if(list.get(i)>=list.get(i+1)) return false;
                }
            }else{
                if(list.get(0)%2!=0) return false;
                for(int i=0;i<list.size()-1;i++){
                    if(list.get(i)%2!=0 || list.get(i+1)%2!=0) return false;
                    if(list.get(i)<=list.get(i+1)) return false;
                }
            }
            c++;
        }
        // System.out.println(ans);
        return true;
    }
}