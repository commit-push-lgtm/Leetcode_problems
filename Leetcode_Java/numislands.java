class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col, directions);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col, int[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // mark as visited

        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], directions);
        }
    }
}