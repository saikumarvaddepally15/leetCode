class Solution {
    private boolean dfs(int start, int col, int color[], List<List<Integer>> graph){
        color[start] = col;
        for (int neighbor : graph.get(start)) {         
            if (color[neighbor] == -1) {
                if (dfs(neighbor, 1 - col, color, graph) == false) return false;
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
    }
   
    public boolean isBipartite(int[][] graphArray) {
        int V = graphArray.length; 
        int[] color = new int[V];
        for (int i = 0; i < V; i++) color[i] = -1;

        // Convert graphArray to adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            for (int j : graphArray[i]) {
                graph.get(i).add(j);
            }
        }
        
        // for connected components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false) return false;
            }
        }
        return true; 
    }
}
