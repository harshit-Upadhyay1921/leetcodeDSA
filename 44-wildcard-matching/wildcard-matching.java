class Solution {
    public boolean helper(String p,String s,int[][] dp,int i,int j){
        if(i<0 && j<0){
            return true;
        }
        if(i<0 && j>=0) return false;
        if(j<0){
            for(int k=0;k<=i;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        } 
        if(dp[i][j]!=-1) return dp[i][j]==1;
        //if(p.charAt(i)!='*' && p.charAt(i)!=s.charAt(j)) return false;
        boolean result=false;
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?') result = helper(p,s,dp,i-1,j-1);
        else if(p.charAt(i)=='*'){
            boolean one = helper(p,s,dp,i,j-1);
            boolean ans = false;
            for(int k=0;k<=j+1;k++){
                if(helper(p,s,dp,i-1,j-k)==true){
                    ans=true;
                    break;
                }
                
            }
            result = ans || one;
        }
        dp[i][j] = result ? 1:0;
        return result;
    }
    public boolean isMatch(String s, String p) {
        int n =  p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(p,s,dp,n-1,m-1);
    }
}