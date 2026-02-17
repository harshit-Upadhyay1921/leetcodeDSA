class Solution {
    public int helper(String s, String t,int[][] dp,int i,int j){
        if(j==0) return 1;
        if(i==0) return 0;
        // if(i==0 && j==0){
        //     if(s.charAt(i)==t.charAt(j)) return 1;
        //     return 0;
        // }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=helper(s,t,dp,i-1,j-1)+helper(s,t,dp,i-1,j);
        }else{
            return dp[i][j]=helper(s,t,dp,i-1,j);
        }

    }
    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int [][] dp = new int[n1+1][n2+1];
        // for(int i=0;i<=n1;i++){
        //     for(int j=0;j<=n2;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(s,t,dp,n1,n2);

        //tabulation
        for(int i=0;i<=n1;i++){  //here j==0 mark as 1 but below line 32
            dp[i][0]=1;
        }
        for(int j=1;j<=n2;j++){ //here j starts from 1 becuz, im again marking it as zero
            dp[0][j]=0;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }  
        } 
        return dp[n1][n2];   
    }
}