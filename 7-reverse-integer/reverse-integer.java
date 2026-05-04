class Solution {
    public int length(int x){
        int len=0;
        while(x>0){
            len++;
            x=x/10;
        }
        return len;
    }
    public int reverse(int x) {
        boolean negFlag=false;
        if(x<0){
            x=-x;
            negFlag=true;
        }
        long num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        int len = length(x);
        System.out.println(len);
        len--;
        while(x>0){
            int rem = x%10;
            num+=(long)(rem*Math.pow(10,len));
            len--;
            if(num<(long)min || num>(long)max) return 0;
            x=x/10;
        }
        if(negFlag){
            return -(int)(num);
        }
        return (int)(num);
    }
}