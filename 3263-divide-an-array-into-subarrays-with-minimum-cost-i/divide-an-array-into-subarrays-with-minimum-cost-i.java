class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int idx=-1;
        for (int i = 1; i < nums.length; i++) {
            if(min1>nums[i]){
                min1=nums[i];
                idx=i;
            }   
        }
        // min2=min1;
        for(int i=1;i<nums.length;i++){
            if(i!=idx && min2>nums[i]){
                min2=nums[i];
            }
        }
        
        return nums[0] + min1 + min2;
    }
}