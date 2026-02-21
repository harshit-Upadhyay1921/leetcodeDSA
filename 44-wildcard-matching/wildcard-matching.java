class Solution {
    public boolean helper(String p,String s,Boolean[][] dp,int i,int j){
        if(i<0 && j<0){
            return true;
        }
        if(i<0) return false;
        if(j<0){
            for(int k=0;k<=i;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        boolean match=false;
        boolean notMatch=false; 
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?') match=helper(p,s,dp,i-1,j-1);
        else if(p.charAt(i)=='*'){
            notMatch=helper(p,s,dp,i-1,j) || helper(p,s,dp,i,j-1);
        }
        else if(p.charAt(i)!=s.charAt(j)) return false;

        return dp[i][j] = match || notMatch;
    }
    public boolean isMatch(String s, String p) {
        int n =  p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m];
        return helper(p,s,dp,n-1,m-1);
    }
}