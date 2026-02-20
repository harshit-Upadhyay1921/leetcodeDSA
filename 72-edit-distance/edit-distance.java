class Solution {
    public int helper(int i,int j,int[][] dp,String w1,String w2){
        if(j<0){
            return i+1;
        }
        if(i<0){
            return j+1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int match=0;
        int notMatchInsert=0;
        int notMatchDelete=0;
        int notMatchReplace=0;
        if(w1.charAt(i)==w2.charAt(j)){
            match=helper(i-1,j-1,dp,w1,w2);
        }else{
            notMatchInsert=1+helper(i,j-1,dp,w1,w2);
            notMatchDelete=1+helper(i-1,j,dp,w1,w2);
            notMatchReplace=1+helper(i-1,j-1,dp,w1,w2);
        }
        return dp[i][j]=match + Math.min(notMatchInsert, Math.min(notMatchDelete, notMatchReplace));
    }
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(n1-1,n2-1,dp,word1,word2);
    }
}