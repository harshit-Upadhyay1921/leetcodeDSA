class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long a=queries[i][0], b=queries[i][1];
            int cnt=1;
            while(a!=b){
                if(a>b) a/=2;
                else b/=2;
                cnt++;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}