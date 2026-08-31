class Solution {

    public int dfs(int row , int col , int[][] grid, boolean[][] visited)
    {
        if(row < 0 || row >= grid.length
                   | col < 0 || col >= grid[0].length) return 0;
        if(visited[row][col]) return 0;
        if(grid[row][col] != 1) return 0;

        visited[row][col] = true;
        int down = dfs(row + 1, col, grid, visited);
        int up = dfs(row - 1, col, grid, visited);
        int right = dfs(row, col + 1, grid, visited);
        int left = dfs(row, col - 1, grid, visited);

        return 1 + (left + right + up + down);
    }

    public int maxAreaOfIsland(int[][] grid) 
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(!visited[i][j])
                {
                    max = Math.max(max, dfs(i , j , grid , visited));
                }
            }
        }
        return max;
    }
}