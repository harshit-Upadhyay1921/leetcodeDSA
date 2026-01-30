class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
          Arrays.sort(deck);
          Queue<Integer> q = new LinkedList<>();
          for(int i=0;i<deck.length;i++){
            q.add(i);
          }
          int[] ans = new int[deck.length];
          int idx=0;
          int c=0;
          while(q.size()!=0){
            if(c%2==0){
                ans[q.poll()]=deck[idx++];
            }else{
                int el=q.poll();
                q.add(el);
            }
            c++;
          }
          return ans;
    }
}