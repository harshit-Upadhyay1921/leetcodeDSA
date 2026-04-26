class Solution {
    public boolean dfs(char[][] grid, int[][] vis, int i, int j, int pI, int pJ) {
        int m = grid.length, n = grid[0].length;
        vis[i][j] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = i + dr[k];
            int ncol = j + dc[k];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                && grid[nrow][ncol] == grid[i][j]) {

                if (vis[nrow][ncol] == 0) {
                    if (dfs(grid, vis, nrow, ncol, i, j)) return true;
                } 
                // else if (!(nrow == pI && ncol == pJ)) {
                //     return true;
                // }
                else if(nrow!=pI && ncol!=pJ) return true;
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    if (dfs(grid, vis, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }
}