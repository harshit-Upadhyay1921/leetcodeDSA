class Solution {
    public int helper(int[] scores, int[] ages,int[][] dp,int i,int last){
        if(i==ages.length) return 0;
        if(dp[i][last+1]!=-1) return dp[i][last+1];
        int pick = -(int)(1e9);
        if(last==-1 || scores[i]>=scores[last]){
            pick = scores[i]+helper(scores,ages,dp,i+1,i);
        }
        int notPick = helper(scores,ages,dp,i+1,last);
        return dp[i][last+1] = Math.max(pick,notPick);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;

        int[][] players = new int[n][2];

        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];   // age
            players[i][1] = scores[i]; // score
        }

        Arrays.sort(players, (a, b) -> {
            if (a[0] == b[0]) {
            return a[1] - b[1];   // sort by score if same age
        }
        return a[0] - b[0];       // sort by age
        });
        for (int i = 0; i < n; i++) {
            ages[i] = players[i][0];
            scores[i] = players[i][1];
        }
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(scores,ages,dp,0,-1);
    }
}