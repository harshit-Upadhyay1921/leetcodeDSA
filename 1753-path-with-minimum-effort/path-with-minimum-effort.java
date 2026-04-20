class Tuple {
    int distance;
    int row;int col;
    Tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;

        PriorityQueue<Tuple> pq = new 
        PriorityQueue<Tuple>((x,y) -> x.distance-y.distance);
        pq.add(new Tuple(0,0,0));

        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int dis = t.distance;
            int row = t.row;
            int col = t.col;
            if(row==m-1 && col==n-1){
                return dis;
            }
            for(int k=0;k<4;k++){
                int nrow = row+dr[k];
                int ncol = col+dc[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),dis);
                    if(newEffort<dist[nrow][ncol]){
                        dist[nrow][ncol]=newEffort;
                        pq.add(new Tuple(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}