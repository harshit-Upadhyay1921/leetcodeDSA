class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;

        int originalK=k;  //6
        Arrays.sort(nums);

        int min=nums[0];  //9918
        int max=Integer.MIN_VALUE;

        int i=1;int s=1; k--; //5
        int ans=Integer.MAX_VALUE;
        while(i<nums.length){
            int el=nums[i];
            max=Math.max(max,el);  //21297  44530 61094 87063 93551
            k--;//4 3 2 1 0
            if(k==0){
                ans=Math.min(ans,Math.abs(max-min));  //83633
                min=nums[s]; 
                s++;
                k++;
            }
            i++;  //2 3 4 5
        }
        return ans;
    }
}