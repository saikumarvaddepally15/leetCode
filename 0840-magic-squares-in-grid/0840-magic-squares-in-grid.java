class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int row=0;row+2<m;row++){
            for(int col=0;col+2<n;col++){
                if(isMagicSquare(grid,row,col)){
                    ans++;
                }
            }
        }
        return ans;
    }


    private boolean isMagicSquare(int[][] grid, int row,int col){
        boolean[] seen= new boolean[10];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num=grid[row+i][col+j];
                if(num<1 || num>9) return false;
                if(seen[num]) return false;
                seen[num]=true;
            }
        }

        int diag1=grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
        int diag2=grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col];

        if(diag1!=diag2) return false;

        int row1=grid[row][col]+grid[row][col+1]+grid[row][col+2];
        int row2=grid[row+1][col]+grid[row+1][col+1]+grid[row+1][col+2];
        int row3=grid[row+2][col]+grid[row+2][col+1]+grid[row+2][col+2];

        if(row1!=row2 || row1!=row3 || row3!=row2 || !(row1==diag1 && row2==diag1 && row3==diag1)){
            return false;
        }
        int col1=grid[row][col]+grid[row+1][col]+grid[row+2][col];
        int col2 =grid[row][col + 1] +grid[row + 1][col + 1] +grid[row + 2][col + 1];
        int col3 =grid[row][col + 2] +grid[row + 1][col + 2] +grid[row + 2][col + 2];

         if (!(col1 == diag1 && col2 == diag1 && col3 == diag1)) {
            return false;
        }
        return true;

    }
    
}