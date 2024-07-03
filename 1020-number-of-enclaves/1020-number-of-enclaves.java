class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int vis[][]=new int[row][col];
        Queue<Pair> q= new LinkedList<Pair>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0 || i==row-1 || j==col-1){                
                    if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                    vis[i][j]=1;                    
                }
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];
                if(nr>=0 && nr<row && nc>=0 && nc<col && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.offer(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}