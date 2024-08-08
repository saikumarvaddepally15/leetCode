class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int steps=0,dir=0;
        int[][] result=new int[rows*cols][2];
        result[0]= new int[]{rStart,cStart};
                int count = 1;
        while(result[0].length<rows*cols){
            if(dir==0 || dir==2) steps++;
            for(int c=0;c<steps;c++){
                rStart+=directions[dir][0];
                cStart+=directions[dir][1];

                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                    result[count++]=new int[]{rStart,cStart};
                }
                if(count==rows*cols) return result;
            }
            dir=(dir+1) %4;
        }

        return result;

        
    }
}