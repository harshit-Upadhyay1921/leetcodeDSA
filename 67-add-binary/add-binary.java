class Solution {
    public String addBinary(String a, String b) {               
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1;int j=b.length()-1;
        char carry='0';
        while(i>=0 && j>=0){
            char e1=a.charAt(i); char e2=b.charAt(j);
            if(e1=='1' && e2=='1'){
                if(carry=='1'){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                carry='1';
            }
            else if((e1=='1' && e2=='0') || (e1=='0' && e2=='1')){
                if(carry=='1'){
                    sb.append('0');
                    carry='1';
                }else{
                    sb.append('1');
                    carry='0';
                }
            }
            else if(e1=='0' && e2=='0'){
                if(carry=='1'){
                    sb.append('1');
                }else{
                    sb.append('0');
                }
                carry='0';
            }
            i--;j--;
        }
        while(i>=0){
            char e1=a.charAt(i);
            if(e1=='1'){
                if(carry=='1'){
                    sb.append('0');
                    carry='1';
                }else{
                    sb.append('1');
                    carry='0';
                }
            }else{
                if(carry=='1'){
                    sb.append('1');
                    carry='0';
                }else{
                    sb.append('0');
                    carry='0';
                }
            }
            i--;
        }
        while(j>=0){
            char e2=b.charAt(j);
            if(e2=='1'){
                if(carry=='1'){
                    sb.append('0');
                    carry='1';
                }else{
                    sb.append('1');
                    carry='0';
                }
            }else{
                if(carry=='1'){
                    sb.append('1');
                    carry='0';
                }else{
                    sb.append('0');
                    carry='0';
                }
            }
            j--;
        }
        if(carry=='1') sb.append('1');
        return sb.reverse().toString();
    }
}