class Solution {
    private static void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol, int r, int c) {
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < r && nCol >= 0 && nCol < c && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, board, delRow, delCol, r, c);
            }
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) return;
        int cols = board[0].length;
        int[][] vis = new int[rows][cols];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Traverse first and last row
        for (int i = 0; i < cols; i++) {
            if (vis[0][i] == 0 && board[0][i] == 'O') {
                dfs(0, i, vis, board, delRow, delCol, rows, cols);
            }
            if (vis[rows - 1][i] == 0 && board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, vis, board, delRow, delCol, rows, cols);
            }
        }

        // Traverse first and last column
        for (int j = 0; j < rows; j++) {
            if (vis[j][0] == 0 && board[j][0] == 'O') {
                dfs(j, 0, vis, board, delRow, delCol, rows, cols);
            }
            if (vis[j][cols - 1] == 0 && board[j][cols - 1] == 'O') {
                dfs(j, cols - 1, vis, board, delRow, delCol, rows, cols);
            }
        }

        // Flip all unvisited 'O's to 'X's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
