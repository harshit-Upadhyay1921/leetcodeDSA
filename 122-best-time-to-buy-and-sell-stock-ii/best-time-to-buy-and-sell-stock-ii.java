class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int maxProfit=0;
        int low=prices[0];
        for(int i=1;i<prices.length;i++){
            int curr=prices[i];
            if(curr>low){
                maxProfit = Math.max(maxProfit,curr-low);
            }
            if(curr<prices[i-1]){
                ans+=maxProfit;//4+3
                low=curr;//3
                maxProfit=0;
            }
        }
        if(low!=prices[prices.length-1]){
            ans+=maxProfit;
        }
        return ans;
    }
}