class Solution {
    private double helper(int poured,int r,int c,double[][] dp){
        if(r<0 || c<0 || r<c) return 0.0;
        if(r==0 && c==0) return poured/1.0;
        if(dp[r][c]!=-1.0) return dp[r][c];
        double leftUp = (helper(poured,r-1,c-1,dp)-1)/2.0;
        double rightUp = (helper(poured,r-1,c,dp)-1)/2.0;
        if(leftUp<0.0) leftUp=0.0;
        if(rightUp<0.0) rightUp=0.0;
        return dp[r][c]=leftUp+rightUp;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        // for(int i=0;i<101;i++){
        //     for(int j=0;j<101;j++){
        //         dp[i][j]=-1.0;
        //     }
        // }
        // return Math.min(1.0, helper(poured,query_row,query_glass,dp));
        dp[0][0]=poured/1.0;
        for(int i=1;i<101;i++){
            for(int j=0;j<=i;j++){
                double leftUp = 0.0;
                double rightUp = 0.0;
                if(i-1>=0 && j-1>=0){
                    leftUp = (dp[i-1][j-1]-1)/2.0;
                    if(leftUp<0) leftUp = 0.0;
                }
                if(i-1>=0){
                    rightUp = (dp[i-1][j]-1)/2.0;
                    if(rightUp<0) rightUp = 0.0;
                }
                dp[i][j] = leftUp+rightUp;
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}