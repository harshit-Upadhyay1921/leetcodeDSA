class Pair {
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        int ans = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.first;
            int cnt = p.second;
            if(word.equals(endWord)){
                ans=cnt;
            }
            int size = word.length();
            for(int i=0;i<size;i++){
                StringBuilder sb = new StringBuilder(word);
                for(int j=0;j<26;j++){
                    char ch=(char)(j+'a');
                    sb.setCharAt(i,ch);
                    if(st.contains(sb.toString())){
                        q.add(new Pair(sb.toString(),cnt+1));
                        st.remove(sb.toString());
                    }
                }
            }
        }
        return ans;
    }
}