class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    public int findUParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u==ulp_v) return;
        int rank_u = rank.get(ulp_u);
        int rank_v = rank.get(ulp_v);
        if(rank_u < rank_v){
            parent.set(ulp_u, ulp_v);
            // rank.set(ulp_v, rank_v + 1);
        }
        else if(rank_u > rank_v){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank_u + 1);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n-1);
        int countExtraConnections = 0;
        for(int i=0;i<connections.length;i++){
            int a = connections[i][0];
            int b = connections[i][1];
            if(ds.findUParent(a)==ds.findUParent(b)){
                countExtraConnections++;
                continue;
            }
            ds.unionByRank(a,b);
        }

        int totalDifferentComponents = 0;
        for(int i=0;i<n;i++){
            if(ds.findUParent(i)==i) totalDifferentComponents++;
        }
        System.out.println(totalDifferentComponents);
        System.out.println(countExtraConnections);
        if((totalDifferentComponents-1) > countExtraConnections) return -1;
        return totalDifferentComponents-1;
    }
}