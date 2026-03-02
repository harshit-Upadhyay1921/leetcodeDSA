class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        else if(n==1) return 10;

        int count=10;
        for(int i=2;i<=n;i++){
            int pro=81;
            int times = i-2;
            int j=8;
            while(times-->0){
                pro*=j;
                j--;
            }
            count+=pro;
        }
        return count;
    }
}