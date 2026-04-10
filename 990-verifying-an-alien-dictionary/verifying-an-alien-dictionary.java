class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0;
        for(char ch:order.toCharArray()){
            map.put(ch,j);
            j++;
        }
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            int i1=0;int i2=0;
            boolean found=false;
            while(i1<w1.length() && i2<w2.length()){
                char ch1=w1.charAt(i1);
                char ch2=w2.charAt(i2);
                if(ch1!=ch2){
                    q.add(ch1);
                    q.add(ch2);
                    found=true;
                    break;
                }
                i1++;i2++;
            }
            if(!found && w1.length()>w2.length()) return false;
        }
        if(q.isEmpty()) return true;
        char el1=q.poll();
        while(!q.isEmpty()){
            char el2=q.poll(); 
            if(map.get(el1)>map.get(el2)) return false;
            el1=el2;
        }
        return true;
    }
}