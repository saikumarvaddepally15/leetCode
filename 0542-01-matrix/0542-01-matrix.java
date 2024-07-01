class Solution {
    class Tuple{
        int first;
        int second;
        int third;
        public Tuple(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int vis[][]=new int[row][col];
        int dist[][]=new int[row][col];
        Queue<Tuple> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    q.add(new Tuple(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] drow={-1,0,1,0};
        int[] dcol={0,+1,0,-1};

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[r][c]=steps;

            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0 && nr<row && nc>=0 && nc<col && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.offer(new Tuple(nr,nc,steps+1));
                }
            }


        }

        return dist;
    }
}