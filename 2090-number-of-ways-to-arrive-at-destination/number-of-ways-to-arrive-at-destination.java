import java.util.*;

class Pair {
    long distance; // changed to long
    int node;
    Pair(long distance, int node){ // changed to long
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int first = roads[i][0];
            int second = roads[i][1];
            int time = roads[i][2];
            adj.get(first).add(new Pair(time,second));
            adj.get(second).add(new Pair(time,first));
        }

        long[] dist = new long[n]; // changed to long
        int[] ways = new int[n];
        Arrays.fill(dist, (long)(1e14)); // fixed initialization
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<Pair> pq = new
        PriorityQueue<Pair>((x,y) -> Long.compare(x.distance, y.distance)); // fixed comparator
        pq.add(new Pair(0,0));

        int mod = 1000000007;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            long dis = p.distance; // changed to long
            int node = p.node;

            for(Pair it:adj.get(node)){
                long newDis = it.distance; // changed to long
                int adjNode = it.node;

                if(dis + newDis < dist[adjNode]){
                    dist[adjNode] = dis + newDis;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dis + newDis, adjNode));
                }
                else if(dis + newDis == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}