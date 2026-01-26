class Solution {
    public int helper(int[] coins,int[][] dp,int amount,int idx){
        if(idx==0){
            if((amount%coins[0])==0) return 1;
            else return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int pick=0;
        if(coins[idx]<=amount) pick=helper(coins,dp,amount-coins[idx],idx);
        int notPick=helper(coins,dp,amount,idx-1);

        return dp[idx][amount]=pick+notPick;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
        for (int j = 0; j <= amount; j++) {
            dp[i][j] = -1;
        }
    }
        return helper(coins,dp,amount,n-1);
    }
}