class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;

        int originalK=k; 
        Arrays.sort(nums);

        int min=nums[0]; 
        int max=Integer.MIN_VALUE;

        int s=1; k--;
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            int el=nums[i]; //el is max only
            k--;
            if(k==0){
                ans=Math.min(ans,Math.abs(el-min)); 
                min=nums[s++]; 
                k++;
            }
        }
        return ans;
    }
}