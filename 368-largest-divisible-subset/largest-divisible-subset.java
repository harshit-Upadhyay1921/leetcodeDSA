class Solution {
    public int helper(int[] nums,int[][] dp,int i,int last){
        if(i==nums.length) return 0;
        if(dp[i][last+1]!=-1) return dp[i][last+1];
        int pick=-(int)(1e9);
        if(last==-1 || (nums[last]%nums[i]==0) || (nums[i]%nums[last]==0)){
            pick = 1+helper(nums,dp,i+1,i);
        }
        int notPick = helper(nums,dp,i+1,last);
        return dp[i][last+1]=Math.max(pick,notPick);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        int maxLen = helper(nums,dp,0,-1);

        List<Integer> list = new ArrayList<>();
        int i=0;int last=-1;
        while(i<n){
            if(last==-1 || (nums[i]%nums[last]==0)){
                if(1+dp[i+1][i+1]==dp[i][last+1]){
                    list.add(nums[i]);
                    last=i;
                }
            }
            i++;
        }
        return list;
    }
}