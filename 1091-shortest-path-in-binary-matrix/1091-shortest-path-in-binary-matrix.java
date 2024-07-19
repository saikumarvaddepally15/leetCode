class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length; 
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        Queue<tuple> q = new LinkedList<>();  
        int[][] dist = new int[n][n]; 
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 1; 
        q.add(new tuple(1, 0, 0)); 

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while (!q.isEmpty()) {
            tuple current = q.poll();
            int dis = current.first;
            int row = current.second;
            int col = current.third;

            if (row == n-1 && col == n-1) return dis;  
            for (int[] dir : directions) {
                int newr = row + dir[0];
                int newc = col + dir[1];
                if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = dis + 1;
                    q.add(new tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1; 
    }
}
