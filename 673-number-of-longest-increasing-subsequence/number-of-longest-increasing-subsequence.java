class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] countDp = new int[n];
        Arrays.fill(countDp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                        countDp[i]=countDp[j];
                    }
                    else if(dp[i]==1+dp[j]){
                        countDp[i]+=countDp[j];
                    }
                }
            }
        }
        int maxi = 0;
    for(int len : dp){
        maxi = Math.max(maxi, len);
    }

    int ans = 0;
    for(int i = 0; i < n; i++){
        if(dp[i] == maxi){
            ans += countDp[i];
        }
    }
    return ans;
    }
}