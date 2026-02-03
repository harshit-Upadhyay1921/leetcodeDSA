class Solution {
    public boolean isTrionic(int[] nums) {  //1 2 5 4 4 2 6
        int n=nums.length;
        if(n==3) return false;
        int p=1;
        if(nums[0]>=nums[1]) return false;
        if(nums[n-2]>=nums[n-1]) return false;
        int lastP=1;
        while(p<n-2){
            if(nums[p]<nums[p+1]){
                lastP=p+1;
                p++;
            }else if(nums[p]==nums[p+1]) return false;
            else{
                break;
            }
        }
        int lastQ=lastP;
        int q=lastP;
        while(q<n-1){
            if(nums[q]>nums[q+1]){
                lastQ=q+1;
                q++;
            }else if(nums[q]==nums[q+1]){
                return false;
            }
            else{
                break;
            }
        }
        while(q<n-1){
            if(nums[q]>=nums[q+1]) return false;
            q++;
        }

        if(lastP>0 && lastP<lastQ && lastQ<n-1) return true;
        else return false;

    }
}