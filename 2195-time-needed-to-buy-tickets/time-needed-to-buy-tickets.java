class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i); // 1 2 3 0
        }
        int count=0;
        while(tickets[k]!=0){//4
            int idx=q.poll();//1
            int el=tickets[idx]-1;//0
            tickets[idx]=el;//[4,0,1,1]
            if(el!=0) q.add(idx);
            count++;//1
        }
        return count;

    }
}