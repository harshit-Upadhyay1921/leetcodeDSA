class Solution {
    public int digitCnt(int x){
        int cnt=0;
        while(x>0){
            int r = x%10;
            if(r!=0 && r!=1 && r!=8){
                cnt++;
            }
            x=x/10;
        }
        return cnt;
    }
    public int rotatedDigits(int n) {
        int ansCnt=0;
        Set<Integer> st= new HashSet<>();
        st.add(2);
        st.add(5);
        st.add(6);
        st.add(9);
        for(int i=2;i<=n;i++){
            boolean flag=true;
            int newCount=0;
            int digitCount = digitCnt(i);
            int temp=i;
            while(temp>0){
                int rem = temp%10;
                if(rem==3 || rem==4 || rem==7){
                    flag=false;
                    break;
                }
                else if(rem!=1 && rem!=8 && rem!=0){
                    newCount++;
                }
                temp=temp/10;
            }
            if(flag==true && newCount==digitCount && digitCount!=0){
                System.out.println(i);
                ansCnt++;
            }
        }
        return ansCnt;
    }
}