class Solution {
    public int maxDistance(int[] colors) {
        int i=0;int j=colors.length-1;
        int maxAns = -1;
        while(i<j){
            if(colors[i]!=colors[j]){
                maxAns = Math.max(maxAns, j-i);
            }
            int left = i+1;
            int right = j-1;
            if(colors[left]!=colors[j]){
                maxAns = Math.max(maxAns, j-left);
            }
            if(colors[i]!=colors[right]){
                maxAns = Math.max(maxAns, right-i);
            }
            i++;j--;
        }
        for(int k=colors.length-1;k>=1;k--){
            if(colors[0]!=colors[k]){
                maxAns = Math.max(maxAns, k);
            }
        }
        for(int k=0;k<colors.length-1;k++){
            if(colors[colors.length-1]!=colors[k]){
                maxAns = Math.max(maxAns, colors.length-1-k);
            }
        }
        return maxAns;
    }
}