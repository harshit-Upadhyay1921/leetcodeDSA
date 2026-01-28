class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int store=k;
        while(q.size()!=1){
            int el=q.poll();
            k--;
            if(k!=0){
                q.add(el);
            }
            if(k==0){
                k=store;
            } 
        }
        return q.poll();
    }
}