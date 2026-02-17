class Solution {
    public int helper(String s, String t,int[][] dp,int i,int j){
        if(j<0) return 1;
        if(i<0) return 0;
        // if(i==0 && j==0){
        //     if(s.charAt(i)==t.charAt(j)) return 1;
        //     return 0;
        // }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(s,t,dp,i-1,j-1)+helper(s,t,dp,i-1,j);
        }else{
            return dp[i][j]=helper(s,t,dp,i-1,j);
        }

    }
    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int [][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,t,dp,n1-1,n2-1);
    }
}