class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0) result[i]=nums[i];
            else if(nums[i]>0) result[i]=nums[(i+nums[i])%n];
            else{
                int idx=i-Math.abs(nums[i]);
                while(idx<0) idx=n+idx;
                result[i]=nums[idx];
            }
        }
        return result;
    }
}