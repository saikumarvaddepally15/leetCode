class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top=0,left=0,right=n-1,bottom=n-1;
        int count = 1;
        int totalcount = n * n;

        while(count<=totalcount){
            for(int i=left;i<=right;i++){
                ans[top][i]=count++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
               ans[i][right]=count++;
            }
            right--;
           
            for(int i=right;i>=left;i--){
                ans[bottom][i]=count++;
            }
             bottom--;           
           
            for(int i=bottom;i>=top;i--){
               ans[i][left]=count++;
            }
            left++;
        }
        return ans;
    }
}