class Solution {
    public int threeSumMulti(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;long count=0;int i=0;
        while(i<n-2){
            int j=i+1;int k=n-1;
            int reqSum=target-nums[i];
            while(j<k){
                if(nums[j]+nums[k]==reqSum){
                    int jCount=1;int kCount=1;
                    if(nums[j]!=nums[k]){
                        while(nums[j]==nums[j+1] && j<k){
                            jCount++;
                            j++;
                        }
                        while(nums[k]==nums[k-1] && j<k){
                            kCount++;
                            k--;
                        }
                        count+=(long)(jCount*kCount);
                    }else{
                        int len = k-j+1;
                        count+=(long)((len*(len-1))/2);
                        break;
                    }
                    j++;//for continuation of loop.
                }else if(nums[j]+nums[k]<reqSum){
                    j++;
                }else{
                    k--;
                }
            }
            i++;
        }
        long mod = (long) 1e9+7;
        int ans = (int)(count%mod);
        return ans;
    }
}