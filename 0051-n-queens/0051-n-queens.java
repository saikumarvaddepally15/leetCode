class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        int[] leftdirection= new int[n];
        int[] upperdiag= new int[2*n-1];
        int[] lowerdiag= new int[2*n-1];
        solve(0,board,res,leftdirection,upperdiag,lowerdiag);
        return res;

    }
    
    private void solve(int col,char[][] board,List<List<String>> res, int[] leftdirection,int[] upperdiag,int[] lowerdiag){
        if(col==board.length){
            List<String> ans= new LinkedList<String>();
            for(int i=0;i<board.length;i++){
            String s= new String(board[i]);
            ans.add(s);
        }
            res.add(ans);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(leftdirection[row]==0 && upperdiag[board.length-1+col-row]==0 && lowerdiag[row+col]==0){
                board[row][col]='Q';
                leftdirection[row]=1;
                upperdiag[board.length-1+col-row]=1;
                lowerdiag[row+col]=1;
                solve(col+1,board,res,leftdirection,upperdiag,lowerdiag);
                board[row][col]='.';
                leftdirection[row]=0;
                upperdiag[board.length-1+col-row]=0;
                lowerdiag[row+col]=0;

            }
        }
    }
}