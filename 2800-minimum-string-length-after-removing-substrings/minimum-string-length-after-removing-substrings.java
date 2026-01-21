class Solution {
    public int minLength(String s) {
        if(s.length()==1) return 1;

        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        int i=1;
        while(i<s.length()){
            char el=s.charAt(i);
            if(st.isEmpty()) st.push(el);
            else if(!st.isEmpty() && ((st.peek()=='A' && el=='B') || (st.peek()=='C' && el=='D'))) st.pop();
            else if(!st.isEmpty()) st.push(el);
            i++;
        }
        return st.size();
    }
}