class Solution {
    public int helper(int[] nums,int[][] dp,int sum,int idx){
        if(idx<0){
            if(sum==0) return 1;
            return 0;
        }
        // if(idx==0){
        //     if(sum==nums[0] || sum==0) return 1;
        //     return 0;
        // }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        if(nums[idx]==0) return 2*helper(nums,dp,sum,idx-1);//handling zeroes
        int pick=0;
        if(nums[idx]<=sum) pick=helper(nums,dp,sum-nums[idx],idx-1);
        int notPick=helper(nums,dp,sum,idx-1);

        return dp[idx][sum]=pick+notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total=0;
        for(int el:nums){
            total+=el;
        }
        if(total-target<0) return 0;
        if((total-target)%2!=0) return 0;
        int requireTarget=(total-target)/2;

        int[][] dp = new int[n][requireTarget+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=requireTarget;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums,dp,requireTarget,n-1);
    }
}