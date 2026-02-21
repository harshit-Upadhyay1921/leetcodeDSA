class Solution {
    public int helper(int[] prices,int[][] dp,int idx,int buy){
        if(idx==prices.length){
            return 0;
        }
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            int take = -prices[idx]+helper(prices,dp,idx+1,0);
            int notTake = helper(prices,dp,idx+1,1);
            profit+=Math.max(take,notTake);
        }
        else{
            int take = prices[idx]+helper(prices,dp,idx+1,1);
            int notTake = helper(prices,dp,idx+1,0);
            profit+=Math.max(take,notTake);
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(prices,dp,0,1);
    }
}