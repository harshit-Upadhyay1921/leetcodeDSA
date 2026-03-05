class Solution {
    public int helper(int[] cuts,int[][] dp,int i,int j){
        if(j-i<2) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = (int)(1e9);
        for(int k=i+1;k<=j-1;k++){
            int totalCost = cuts[j]-cuts[i] + helper(cuts,dp,i,k) + helper(cuts,dp,k,j);
            mini = Math.min(mini,totalCost);
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len=cuts.length;
        int[] newArr = new int[len+2];
        int idx=0;
        for(int i=0;i<newArr.length;i++){
            if(i==0) newArr[0]=0;
            else if(i==newArr.length-1) newArr[i]=n;
            else newArr[i]=cuts[idx++];
        }
        int[][] dp = new int[newArr.length+1][newArr.length+1];
        for(int i=0;i<newArr.length+1;i++){
            for(int j=0;j<newArr.length+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(newArr,dp,0,newArr.length-1);
    }
}