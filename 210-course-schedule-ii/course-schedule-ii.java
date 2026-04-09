class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==1) return new int[]{0};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int first = prerequisites[i][0];
            int sec = prerequisites[i][1];
            adj.get(sec).add(first);
            indegree[first]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        int[] ans = new int[numCourses];
        int idx=0;
        int count=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            count++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(count==numCourses) return ans;
        int[] empty = new int[0];
        return empty;
    }
}
