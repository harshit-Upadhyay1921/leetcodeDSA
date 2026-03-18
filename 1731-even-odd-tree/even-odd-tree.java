
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
                if(!reverse){
                    TreeNode node = q.removeFirst();
                    list.add(node.val);
                    if(node.left!=null) q.addLast(node.left);
                    if(node.right!=null) q.addLast(node.right);
                }else{
                    TreeNode node = q.removeLast();
                    list.add(node.val);
                    if(node.right!=null) q.addFirst(node.right);
                    if(node.left!=null) q.addFirst(node.left);
                }
            }
            reverse=!reverse;
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
                    if(list.get(i)>=list.get(i+1)) return false;
                }
            }
            c++;
        }
        // System.out.println(ans);
        return true;
    }
}