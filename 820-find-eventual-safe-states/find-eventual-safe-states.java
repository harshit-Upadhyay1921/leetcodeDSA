class Solution {
    public boolean dfs(int node,List<List<Integer>> adj,int[] vis,int[] pathVis,List<Integer> list){
        vis[node]=1;
        pathVis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]!=1){
                if(dfs(it,adj,vis,pathVis,list)==true) return true;
            }
            else if(pathVis[it]==1) return true;
        }
        list.add(node);
        pathVis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(i,adj,vis,pathVis,list);
            }
        }
        Collections.sort(list);
        return list;
    }
}