class Pair {
    int first;int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int totalSteps(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int n=nums.length;
        if(n==1) return 0;
        st.add(new Pair(nums[n-1],0));
        int max = -1;
        for(int i=n-2;i>=0;i--){
            int steps=0;
            while(!st.isEmpty() && nums[i]>st.peek().first){
                steps=Math.max(steps+1, st.peek().second);
                st.pop();
            }
            st.push(new Pair(nums[i],steps));
            max = Math.max(max,steps);
        }
    
        return max;
    }
}