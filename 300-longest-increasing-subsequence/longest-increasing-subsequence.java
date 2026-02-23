class Solution {
    public int helper(int[] nums, int[][] dp,int idx,int lastIdx){
        if(idx==nums.length) {
            return 0;
        }
        if(dp[idx][lastIdx+1]!=-1) return dp[idx][lastIdx+1];
        int pick = -(int)(1e9);
        if(lastIdx==-1 || nums[idx]>nums[lastIdx]) pick = 1+helper(nums,dp,idx+1,idx);
        int notPick = helper(nums,dp,idx+1,lastIdx);

        return dp[idx][lastIdx+1]=Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        // int lastPicked = -(int)(1e9);  //can not memoize using element have to use index.
        int n=nums.length;
        // int[][] dp = new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(nums,dp,0,-1);

        //tabulation
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int pick = -(int)(1e9);
                if(j==-1 || nums[i]>nums[j]) pick = 1+dp[i+1][i+1];
                int notPick = dp[i+1][j+1];

                dp[i][j+1]=Math.max(pick,notPick);
            }
        }
        return dp[0][0];
    }
}