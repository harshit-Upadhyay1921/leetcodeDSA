class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);//1 1 0
        boolean flag=false;
        int ans = Integer.MIN_VALUE;
        int zero=0;
        int pos1=-1; int pos2=-1;
        for(int i=binary.length()-1;i>=0;i--){
            char ch=binary.charAt(i);
            if(flag==false && ch=='1'){
                flag=true;
                pos1=binary.length()-i-1;
            }
            else if(flag==true && ch=='1'){
                pos2=binary.length()-i-1;
                ans = Math.max(ans, Math.abs(pos2-pos1));
                pos1=pos2;
            }
        }
        if(ans==Integer.MIN_VALUE) return 0;
        return ans;
    }
}