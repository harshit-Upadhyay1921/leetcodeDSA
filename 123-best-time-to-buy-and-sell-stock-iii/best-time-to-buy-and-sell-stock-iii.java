class Solution {
    public int helper(int[] prices,int[][][] dp,int i,int buy,int cap){
        if(i==prices.length) return 0;
        if(cap==0) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1){
            int take = -prices[i]+helper(prices,dp,i+1,0,cap);
            int not = helper(prices,dp,i+1,1,cap);
            profit = Math.max(take,not);
        }else{
            int take = prices[i]+helper(prices,dp,i+1,1,cap-1);
            int not = helper(prices,dp,i+1,0,cap);
            profit = Math.max(take,not);
        }
        return dp[i][buy][cap]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int c=0;c<3;c++){
                    dp[i][j][c]=-1;
                }
            }
        }
        return helper(prices,dp,0,1,2);
    }
}