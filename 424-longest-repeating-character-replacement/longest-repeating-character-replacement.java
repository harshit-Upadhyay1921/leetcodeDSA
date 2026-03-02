class Solution {
    private int updateMaxFreq(HashMap<Character,Integer> map){
        int maxFreq=-1;
        for(char i:map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(i));
        }
        return maxFreq;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq=0;int maxLen=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        for(int j=0;j<n;j++){
            char el=s.charAt(j);
            map.put(el,map.getOrDefault(el,0)+1);
            maxFreq = Math.max(maxFreq,map.get(el));
            while((j-i+1)-maxFreq > k){
                char el_st=s.charAt(i);
                map.put(el_st,map.get(el_st)-1);
                if(map.get(el_st)==0) map.remove(el_st);
                maxFreq = updateMaxFreq(map);
                i++;
            }
            maxLen = Math.max(maxLen,(j-i+1));
        }
        return maxLen;
    }
}