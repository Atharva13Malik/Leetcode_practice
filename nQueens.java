class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();

        char[][] grid = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        nQueens(0, grid, list);
        return list;
    }

    public void nQueens(int row, char[][] grid, List<List<String>> list) {
        int n = grid.length;

        if(row == n) {
            List<String> board = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                board.add(new String(grid[i]));
            }

            list.add(board);
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, grid)) {
                grid[row][col] = 'Q';
                nQueens(row + 1, grid, list);
                grid[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] grid) {
        int n = grid.length;

        // check column
        int i = row - 1;
        while(i >= 0) {
            if(grid[i][col] == 'Q') return false;
            i--;
        }

        // check upper-left diagonal
        i = row - 1;
        int j = col - 1;

        while(i >= 0 && j >= 0) {
            if(grid[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while(i >= 0 && j < n) {
            if(grid[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }
}
