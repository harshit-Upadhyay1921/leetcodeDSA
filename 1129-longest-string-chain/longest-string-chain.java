class Solution {
    public boolean checkDiffer(String s1,String s2){
        if(Math.abs(s1.length()-s2.length())!=1) return false;
        String small = s1.length() < s2.length() ? s1 : s2;
        String large = s1.length() < s2.length() ? s2 : s1;

        int i=0;int j=0;int differ=0;
        while(i<small.length() && j<large.length()){
            char c1 = small.charAt(i);
            char c2 = large.charAt(j);
            if(c1==c2){
                i++;j++;
            }
            else{
                j++;
                differ++;
            }
            if(differ>1) return false;
        }
        return true;
    }
    public int helper(String[] words,int[][] dp,int idx,int last){
        if(idx==words.length) return 0;
        int pick = -(int)(1e9);
        if(dp[idx][last+1]!=-1) return dp[idx][last+1];
        if(last==-1 || checkDiffer(words[idx],words[last])==true){
            pick = 1+helper(words,dp,idx+1,idx);
        }
        int notPick = helper(words,dp,idx+1,last);
        return dp[idx][last+1]=Math.max(pick,notPick);
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        int n = words.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(words,dp,0,-1);
    }
}