class Solution {
    public int helper(int[] coins,int[][] dp,int amount,int idx){
        if(idx==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return (int)(1e9);
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int pick=(int)(1e9);
        if(coins[idx]<=amount) pick=1+helper(coins,dp,amount-coins[idx],idx);  //keep idx still
        int notPick=helper(coins,dp,amount,idx-1);

        return dp[idx][amount]=Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=amount;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // int ans = helper(coins,dp,amount,n-1);
        // if(ans==(int)(1e9)) return -1;
        // return ans;

        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j]=j/coins[0];
            else dp[0][j]=(int)(1e9);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int pick=(int)(1e9);
                if(coins[i]<=j) pick=1+dp[i][j-coins[i]];
                int notPick=dp[i-1][j];
                dp[i][j]=Math.min(pick,notPick);
            }
        }
        if(dp[n-1][amount]==(int)(1e9)) return -1;
        return dp[n-1][amount];
    }
}