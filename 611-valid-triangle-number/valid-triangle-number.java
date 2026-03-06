class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        int i=0;
        while(i<n-2){  // 3 19 22 24 35 82 84
            int j=i+1;int k=n-1;
            while(j<k){
                if(nums[i]+nums[j]>nums[k]){
                    count+=(k-j);
                    j=i+1;
                    k--;
                }
                else{
                    if(j==k-1){
                        j=i+1;k--;
                    }
                    else j++;
                }
            }
            i++;
        }
        return count;
    }
}