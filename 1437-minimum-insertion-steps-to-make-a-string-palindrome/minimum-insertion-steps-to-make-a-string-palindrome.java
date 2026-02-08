class Solution {
    public int helper(String s1,String s2,int[][] dp,int i1,int i2){
        if(i1==0 || i2==0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(s1.charAt(i1-1)==s2.charAt(i2-1)){
            return dp[i1][i2]=1+helper(s1,s2,dp,i1-1,i2-1);
        }else{
            return dp[i2][i2]=Math.max(helper(s1,s2,dp,i1-1,i2),helper(s1,s2,dp,i1,i2-1));
        }
    }
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int n1=s.length();
        int[][] dp = new int[n1+1][n1+1];
        // for(int i=0;i<=n1;i++){
        //     for(int j=0;j<=n1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // int lps = helper(s,sb.reverse().toString(),dp,n1,n1);
        String s2 = sb.reverse().toString();
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n1;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n1-dp[n1][n1];
    }
}