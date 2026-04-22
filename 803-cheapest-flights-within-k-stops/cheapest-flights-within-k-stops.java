class Tuple {
    int stops,node,cost;
    Tuple(int stops,int node,int cost){
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Pair {
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adj.get(from).add(new Pair(to,price));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));

        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stops = t.stops;
            int node = t.node;
            int cost = t.cost;

            for(Pair it:adj.get(node)){
                int adjNode = it.first;
                int reqCost = it.second;
                if(stops<=k){
                    if(cost+reqCost<dist[adjNode]){
                        dist[adjNode]=cost+reqCost;
                        q.add(new Tuple(stops+1,adjNode,cost+reqCost));
                    }
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }
}