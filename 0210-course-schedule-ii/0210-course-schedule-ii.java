class Solution {
    public int[] findOrder(int v, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q= new LinkedList<Integer>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
      int[] topo=new int[v];
      int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[i++]=node;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

        }
        if(i==v) return topo;
       int arr[]={};
       return arr;
}
}