
class Solution {
    public void helper(TreeNode root,List<Integer> list,List<List<Integer>> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        list.add(root.val);
        helper(root.left,list,ans);
        helper(root.right,list,ans);
        list.remove(list.size()-1);

    }
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root,list,ans);
        int totalSum=0;
        for(List<Integer> l : ans){
            int size = l.size();
            int num=0;
            for(int i=0;i<size;i++){
                int el=l.get(i);
                num+=(el*Math.pow(10,size-1-i));
            }
            totalSum+=num;
        }
        return totalSum;
    }
}