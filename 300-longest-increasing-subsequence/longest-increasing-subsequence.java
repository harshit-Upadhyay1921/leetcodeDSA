class Solution {
    public int binarySearch(List<Integer> list,int el){
        int l=0;int r=list.size()-1;  //1 4 5 9
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid)==el) return mid;
            else if(list.get(mid)<el) l=mid+1;
            else{
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int el = nums[i];
            if(list.isEmpty() || list.get(list.size()-1)<el){
                list.add(el);
            }else{
                int idx = binarySearch(list,el);
                list.set(idx,el);
            }
        }
        return list.size();
    }
}