class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int count=0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(count==numCourses) return true;
        return false;
    }
}