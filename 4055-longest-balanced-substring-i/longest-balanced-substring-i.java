class Solution {
    private boolean valid(HashMap<Character, Integer> map) {
    if (map.isEmpty()) return false;
    if(map.size()==1) return true;
    int firstValue = -1;

    for (int value : map.values()) {
        if (firstValue == -1) {
            firstValue = value;
        } else if (value != firstValue) {
            return false;
        }
    }

    return true;
}

    public int longestBalanced(String s) {
        int max=-1;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);
                if(valid(map)){
                    max = Math.max(max,j-i+1);
                }
            }
            
        }
        return max;
    }
}