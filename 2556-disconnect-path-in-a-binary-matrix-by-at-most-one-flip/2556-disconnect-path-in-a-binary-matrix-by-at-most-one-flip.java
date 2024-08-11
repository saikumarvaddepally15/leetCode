class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if (!isReachable(grid, 0, 0)) {
            return true;   
        }
        grid[0][0] = 1; 
        if (!isReachable(grid, 0, 0)) {
            return true; 
        }

        return false;
    }

    private boolean isReachable(int[][] grid, int i, int j){
       if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;    
        }
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return false;   
        }
        grid[i][j] = 0;
        return isReachable(grid, i + 1, j) || isReachable(grid, i, j + 1);
    }
}