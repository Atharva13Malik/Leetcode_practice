class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] visited = new boolean[n][m];

        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        dfs(image, sr, sc, visited, color, originalColor);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, boolean[][] visited, int color, int originalColor) {
        int n = image.length;
        int m = image[0].length;

        if (sr < 0 || sc < 0 || sr >= n || sc >= m ||
            visited[sr][sc] ||
            image[sr][sc] != originalColor)
            return;

        visited[sr][sc] = true;
        image[sr][sc] = color;

        dfs(image, sr - 1, sc, visited, color, originalColor);
        dfs(image, sr + 1, sc, visited, color, originalColor);
        dfs(image, sr, sc - 1, visited, color, originalColor);
        dfs(image, sr, sc + 1, visited, color, originalColor);
    }
}
