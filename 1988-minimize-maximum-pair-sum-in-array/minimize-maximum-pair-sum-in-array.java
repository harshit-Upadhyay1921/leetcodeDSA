class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        if(n==2) return nums[0]+nums[1];
        Arrays.sort(nums);
        int i=0; int j=n-1;
        int maxSum=Integer.MIN_VALUE;
        while(i<j){
            maxSum=Math.max(maxSum,(nums[i]+nums[j]));
            i++;j--;
        }
        return maxSum;
    }
}