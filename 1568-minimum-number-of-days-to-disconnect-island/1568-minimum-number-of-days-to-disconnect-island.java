class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int row, int col, int[][] vis, int[][] grid) {
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 1, 0, 0}; // Directions for up, down
        int[] dcol = {0, 0, -1, 1}; // Directions for left, right
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int numOfIslands = numIslands(grid);
        if (numOfIslands > 1 || numOfIslands == 0) {
            return 0;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        numOfIslands = numIslands(grid);
                        if (numOfIslands > 1 || numOfIslands == 0) return 1;
                        grid[i][j] = 1;
                    }
                }
            }
        }
        return 2;
    }
}
