class Solution {
    public int helper(int[] nums,int[] dp,int idx){
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int pick= nums[idx-1] | helper(nums,dp,idx-1);
        int notPick = helper(nums,dp,idx-1);
        return dp[idx]=Math.max(pick,notPick);

    }
    public int findCount(int[] nums,int idx,int maxOr,int currOr){
        if(idx==0){
            if(maxOr==currOr) return 1;
            return 0;
        }
        int pick = findCount(nums,idx-1,maxOr,currOr | nums[idx-1]);
        int notPick = findCount(nums,idx-1,maxOr,currOr);
        return pick+notPick;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];//created n+1 dp for memo, for easy convert to tabu.
        Arrays.fill(dp,-1);
        int maxOr = helper(nums,dp,n);
        return findCount(nums,n,maxOr,0);
        // dp[0]=0;
        // for(int i=1;i<=n;i++){
        //     int pick= nums[i-1] | dp[i-1];
        //     int notPick = dp[i-1];
        //     dp[i]=Math.max(pick,notPick);
        // }

        
    }
}