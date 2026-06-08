class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();

        int n = maze.length;

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        helper(0, 0, n - 1, n - 1, visited, maze, ans, "");

        Collections.sort(ans);

        return ans;
    }

    public void helper(int r, int c, int er, int ec,
                       boolean[][] visited,
                       int[][] maze,
                       ArrayList<String> ans,
                       String path) {

        if (r < 0 || c < 0 || r > er || c > ec ||
            maze[r][c] == 0 || visited[r][c]) {
            return;
        }

        if (r == er && c == ec) {
            ans.add(path);
            return;
        }

        visited[r][c] = true;

        helper(r + 1, c, er, ec, visited, maze, ans, path + "D");
        helper(r, c - 1, er, ec, visited, maze, ans, path + "L");
        helper(r, c + 1, er, ec, visited, maze, ans, path + "R");
        helper(r - 1, c, er, ec, visited, maze, ans, path + "U");

        visited[r][c] = false;
    }
}
