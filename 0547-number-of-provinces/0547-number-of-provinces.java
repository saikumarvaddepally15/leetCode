class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        int v = isConnected.length;
         for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
     
      for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int vis[] =new int[v];
        int c=0;
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                c++;
                dfs(i,adj,vis);
            }
        }
        return c;
    }
    private static void dfs(int node,  ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis);
            }
        }
    }
}