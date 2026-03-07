class Solution {
    public int helper(String a,String b,int[][] dp,int i1,int i2){
        if(i1==0 || i2==0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int match=-(int)(1e9);
        if(a.charAt(i1-1)==b.charAt(i2-1)){
            match = 1+helper(a,b,dp,i1-1,i2-1);
        }
        int notMatch = Math.max(helper(a,b,dp,i1-1,i2),helper(a,b,dp,i1,i2-1));
        return dp[i1][i2]=Math.max(match,notMatch);
    }
    public int findLUSlength(String a, String b) {
        int n=a.length();int m=b.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // int maxCommon = helper(a,b,dp,n,m);
        // if(maxCommon==n && n==m) return -1; //
        // return Math.max(n-maxCommon,m-maxCommon);
        if(a.equals(b)) return -1;
        return Math.max(n,m);
    }
}