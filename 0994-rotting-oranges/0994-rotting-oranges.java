class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        
        int rows=grid.length;
        int col=grid[0].length;
        int[][] vis= new int[rows][col];
        Queue<int[]> q=new LinkedList<>();
        int cnt_fresh=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    vis[i][j]=2;
                }
                if(grid[i][j]==1){
                    cnt_fresh++;
                }
            }
        }
        if(cnt_fresh==0)  return 0;
        int cntMin=0;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] point= q.poll();
                for(int j=0;j<4;j++){
                    int x=point[0]+dx[j];
                    int y=point[1]+dy[j];

                    if(x>=0 && x<rows && y>=0 && y<col && vis[x][y]==0 && grid[x][y]==1){
                        q.offer(new int[]{x,y});
                        vis[x][y]=2;
                        cnt_fresh--;
                    }
                }
            }
            if(!q.isEmpty()){
                cntMin++;
            }
        }
        return cnt_fresh == 0 ? cntMin : -1;
    }
}
