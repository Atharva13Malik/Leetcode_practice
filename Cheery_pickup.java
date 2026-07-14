class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int dp[][][]=new int[n][n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return Math.max(0,solve(0,0,0,dp,grid));
    }
    public int solve(int r1,int c1,int r2,int dp[][][],int grid[][]){
        int c2=r1+c1-r2;
        int n=grid.length;
        if(r1>=n || r2>=n || c2>=n || c1>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return -1000000000;
        }
        if(r1==n-1 && c1==n-1) return grid[r1][c1];
        if(dp[r1][c1][r2]!=-1 ) return dp[r1][c1][r2];

        int cherry=grid[r1][c1];

        if(r1!=r2 || c1!=c2){
            cherry+=grid[r2][c2];
        }

        int rr = solve(r1,     c1 + 1, r2,     dp, grid);   // A -> Right, B -> Right

        int rd = solve(r1,     c1 + 1, r2 + 1, dp, grid);   // A -> Right, B -> Down

        int dr = solve(r1 + 1, c1,     r2,     dp, grid);   // A -> Down,  B -> Right

        int dd = solve(r1 + 1, c1,     r2 + 1, dp, grid);   // A -> Down,  B -> Down

        int best = Math.max(
                Math.max(rr, rd),
                Math.max(dr, dd)
           );

        dp[r1][c1][r2] = cherry + best;

         return dp[r1][c1][r2];
    }
}
