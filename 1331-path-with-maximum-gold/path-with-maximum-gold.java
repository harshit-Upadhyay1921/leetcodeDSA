class Solution {
    public void dfs(int[][] grid,int[][] vis,int[] max,int i,int j,int sum){
        int m=grid.length;
        int n=grid[0].length;
        vis[i][j]=1;
        max[0] = Math.max(max[0],sum);
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow = i+dr[k];
            int ncol = j+dc[k];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=0 && vis[nrow][ncol]==0){
                dfs(grid,vis,max,nrow,ncol,sum+grid[nrow][ncol]);
            }
        }
        vis[i][j]=0;
    }
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;int n=grid[0].length;
        int[][] vis = new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]!=0){
                    int[] max = new int[1];
                    max[0] = grid[i][j];
                    dfs(grid,vis,max,i,j,grid[i][j]);
                    ans = Math.max(ans,max[0]);
                }
            }
        }
        return ans;
    }
}