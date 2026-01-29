class Solution {
    private int helper(String text1,String text2,int[][] dp,int i1,int i2){
        if(i1<0 || i2<0) return 0;
        // if(i1==0 && i2==0){
        //     if(text1.charAt(i1)==text2.charAt(i2)) return 1;
        //     // return 0;
        // }
        // if(i1==0 && i2!=0){
        //     if(text1.charAt(i1)==text2.charAt(i2)){
        //         return 1+helper(text1,text2,dp,i1,i2-1);
        //     }
        //     return helper(text1,text2,dp,i1,i2-1);
        // }
        // if(i2==0 && i1!=0){
        //     if(text1.charAt(i1)==text2.charAt(i2)){
        //         return 1+helper(text1,text2,dp,i1-1,i2);
        //     }
        //     return helper(text1,text2,dp,i1-1,i2);
        // }
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int match=-(int)(1e9);
        if(text1.charAt(i1)==text2.charAt(i2)){
            match = 1+helper(text1,text2,dp,i1-1,i2-1);
        }
        int notMatch=Math.max(helper(text1,text2,dp,i1-1,i2),helper(text1,text2,dp,i1,i2-1));

        return dp[i1][i2]=Math.max(match,notMatch);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(text1,text2,dp,n1-1,n2-1);
    }
}