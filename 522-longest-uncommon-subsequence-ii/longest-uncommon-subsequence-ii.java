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
    public int findLUSlength(String[] strs) {
        int ans=-1;
        for(int i=0;i<strs.length;i++){
            String a=strs[i]; 
            int n=a.length(); 
            int c=0;
            for(int j=0;j<strs.length;j++){
                if(j==i) continue;
                String b=strs[j];int m=b.length();
                int[][] dp = new int[n+1][m+1];
                for(int k=0;k<n+1;k++){
                    for(int l=0;l<m+1;l++){
                        dp[k][l]=-1;
                    }
                }
                int maxComm = helper(a,b,dp,n,m);
                if(maxComm!=n){
                    c++;
                }
            }
            if(c==strs.length-1)ans=Math.max(ans,n);
        }
        return ans;
    }
}