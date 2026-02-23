class Solution {
    public int helper(int[] prices, int[][] dp, int idx, int buy, int fee){
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            int take = -prices[idx]+helper(prices,dp,idx+1,0,fee);
            int not = helper(prices,dp,idx+1,1,fee);
            profit = Math.max(take, not);
        }
        else{
            int take = prices[idx]-fee+helper(prices,dp,idx+1,1,fee);
            int not = helper(prices,dp,idx+1,0,fee);
            profit = Math.max(take, not);
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(prices, dp, 0, 1, fee);
    }
}