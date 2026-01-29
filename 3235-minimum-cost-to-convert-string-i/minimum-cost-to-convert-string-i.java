class Pair {
    char first;
    long second;
    Pair(char first,long second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private long dijkstra(char src,char dest,long[] dist,List<List<Pair>> adj){
        Arrays.fill(dist,(long)(1e9));
        dist[src-'a']=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.second, y.second));
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            char node=p.first;
            long dis=p.second;
            for(Pair it:adj.get(node-'a')){
                char adjNode=it.first;
                long wt=it.second;
                if(dis+wt<dist[adjNode-'a']){
                    dist[adjNode-'a']=dis+wt;
                    pq.add(new Pair(adjNode,dis+wt));
                }
            }
        }
        return dist[dest-'a'];
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Set<Character> set = new HashSet<>();
        // for(char ch:source.toCharArray()){
        //     set.add(ch);
        // }
        // for(char ch:target.toCharArray()){
        //     set.add(ch);
        // }
        int totalChars=26;

        List<List<Pair>> adj = new ArrayList<>();
        for(int k=0;k<totalChars;k++){
            adj.add(new ArrayList<>());
        }
        for(int k=0;k<original.length;k++){
            char first=original[k];
            char second=changed[k];
            long third=cost[k];
            adj.get(first-'a').add(new Pair(second,third));
        }
        long[] dist = new long[totalChars];

        long[][] dp = new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                dp[i][j]=-1;
            }
        }
        long totalCost=0;
        for(int k=0;k<source.length();k++){
            char src=source.charAt(k);
            char dest=target.charAt(k);
            if(src==dest) totalCost+=0;
            else if(dp[src-'a'][dest-'a']!=-1 && src!=dest) totalCost+=dp[src-'a'][dest-'a'];
            else if(dp[src-'a'][dest-'a']==-1 && src!=dest){
                long ans=dijkstra(src,dest,dist,adj);
                if(ans==(long)(1e9)) return -1;
                totalCost+=ans;
                dp[src-'a'][dest-'a']=ans;
            }
        }
        return totalCost;
    }
}