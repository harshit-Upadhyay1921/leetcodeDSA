class Solution {
    public int longestBalanced(int[] nums) {
        int l=0;
        int r=0;
        int n=nums.length;
        int even=0;int odd=0;
        int max=0;
        Set<Integer> setEve = new HashSet<>();
        Set<Integer> setOdd = new HashSet<>();
        // while(r<n){
        //     if(nums[r]%2==0){
        //         setEve.add(nums[r]);
        //     }
        //     else{
        //         setOdd.add(nums[r]);
        //     }
        //     if(setOdd.size()==setEve.size()){
        //         max = Math.max(max,(r-l+1));
        //     }
        //     r++;
        // }
        // return max;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(nums[j]%2==0){
                    setEve.add(nums[j]);
                }else{
                    setOdd.add(nums[j]);
                }
                if(setEve.size()==setOdd.size()){
                    max=Math.max((j-i+1),max);
                }
            }
            setEve.clear();
            setOdd.clear();
        }
        return max;
    }
}