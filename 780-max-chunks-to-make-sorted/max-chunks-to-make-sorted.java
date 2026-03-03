class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int chunk=0;
        int currSum=0;int expectedSum=0;
        for(int i=0;i<n;i++){
            currSum+=arr[i];
            expectedSum=(i*(i+1))/2;
            if(currSum==expectedSum) chunk++;
        }
        return chunk;
    }
}