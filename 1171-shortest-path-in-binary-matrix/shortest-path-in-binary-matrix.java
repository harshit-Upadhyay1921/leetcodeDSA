class Tuple {
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,1));

        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0]=1;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int r = t.first;
            int c = t.second;
            int dis = t.third;
            int[] dr = new int[] {-1,-1,-1,0,1,1,1,0};
            int[] dc = new int[] {-1,0,1,1,1,0,-1,-1};
            for(int k=0;k<8;k++){
                int nrow = r+dr[k];
                int ncol = c+dc[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0){
                    if(dis+1<dist[nrow][ncol]){
                        dist[nrow][ncol]=dis+1;
                        q.add(new Tuple(nrow,ncol,dis+1));
                    }
                }
            }
        }
        if(dist[n-1][n-1]==(int)(1e9)) return -1;
        return dist[n-1][n-1];
    }
}