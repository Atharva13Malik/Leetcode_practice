import java.util.*;

class Solution {

    int count;

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        count = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(!visited[i][j] && grid[i][j] == '1') {

                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));

        visited[i][j] = true;

        while(!q.isEmpty()) {

            Pair front = q.remove();

            int row = front.row;
            int col = front.col;

            // up
            if(row > 0) {

                if(!visited[row - 1][col] && grid[row - 1][col] == '1') {

                    q.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
            }

            // left
            if(col > 0) {

                if(!visited[row][col - 1] && grid[row][col - 1] == '1') {

                    q.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }

            // down
            if(row < grid.length - 1) {

                if(!visited[row + 1][col] && grid[row + 1][col] == '1') {

                    q.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
            }

            // right
            if(col < grid[0].length - 1) {

                if(!visited[row][col + 1] && grid[row][col + 1] == '1') {

                    q.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }
        }
    }
}
