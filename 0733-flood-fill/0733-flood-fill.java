class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor=image[sr][sc];
        int[][] ans=image;
        dfs(image,ans,sr,sc,color,startColor);
        return ans;
    }
    private void dfs(int[][] image,int[][] ans,int row, int col,int color,int startColor){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==startColor && ans[nr][nc] !=color){
                dfs(image,ans,nr,nc,color,startColor);
            }
        }
    }
}