class Solution {
  
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }
         int vis[]=new int[V];
        int pathvis[]= new int[V];
        int check[]=new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
               dfs(i,vis,pathvis,adj,check);
            }
        }
        List<Integer> safenodes=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) safenodes.add(i);
        }
        return safenodes;
        
    }

     private boolean dfs(int node, int vis[],int pathvis[],ArrayList<ArrayList<Integer>> adj,int check[]) {
    vis[node]=1;
    pathvis[node]=1;
    check[node]=0;
    for(int it:adj.get(node)){
        if(vis[it]==0){
        if(dfs(it,vis,pathvis,adj,check)==true) return true;
        }
    else if(pathvis[it]==1){
        return true;
    }
    }
    check[node]=1;
    pathvis[node]=0;
    return false;
    }
}