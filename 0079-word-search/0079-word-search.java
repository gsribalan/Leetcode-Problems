class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (recur(board, word, r, c, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recur(char[][] board, String word, int r, int c, boolean[][] visited, int k) {
        if (k == word.length()) return true;
        
        // Correct boundary & matching checks
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || visited[r][c] || board[r][c] != word.charAt(k)) {
            return false;
        }

        visited[r][c] = true;

        // Return true immediately if any branch finds the full word
        if (recur(board, word, r + 1, c, visited, k + 1) ||
            recur(board, word, r, c + 1, visited, k + 1) ||
            recur(board, word, r - 1, c, visited, k + 1) ||
            recur(board, word, r, c - 1, visited, k + 1)) {
            return true;
        }

        visited[r][c] = false; // Backtrack
        return false;
    }
}