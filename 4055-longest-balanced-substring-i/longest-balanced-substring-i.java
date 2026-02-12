class Solution {
   

    public int longestBalanced(String s) {
        int max=-1;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            int distinct=0;
            int maxFreq=0;
            for(int j=i;j<s.length();j++){
                int idx=s.charAt(j)-'a';
                if(freq[idx]==0) distinct++;
                freq[idx]++;
                maxFreq = Math.max(maxFreq,freq[idx]);
                if(maxFreq*distinct==(j-i+1)){
                    max=Math.max(max,(j-i+1));
                }
            }
            
        }
        return max;
    }
}