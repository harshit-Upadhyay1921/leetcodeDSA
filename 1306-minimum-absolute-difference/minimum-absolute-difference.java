class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            minDiff=Math.min(minDiff,(arr[i+1]-arr[i]));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if((arr[i+1]-arr[i])==minDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }
        return ans;
    }
}