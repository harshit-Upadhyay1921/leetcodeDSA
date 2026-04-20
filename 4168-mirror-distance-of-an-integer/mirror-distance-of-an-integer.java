class Solution {
    public int length(int n){
        int len=0;
        while(n>0){
            len++;
            n=n/10;
        }
        return len;
    }
    public int mirrorDistance(int n) {
        int temp = n;
        int rev = 0;
        int len = length(n);
        len--;
        while(temp>0){
            int r = temp%10;
            rev += r*Math.pow(10,len);
            len--;
            temp=temp/10;
        }
        return Math.abs(n-rev);
    }
}