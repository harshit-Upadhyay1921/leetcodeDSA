class Pair {
    int num;int den;
    Pair(int num,int den){
        this.num=num;
        this.den=den;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if(k==1) return new int[]{arr[0],arr[arr.length-1]};
        PriorityQueue<Pair> pq = new 
        PriorityQueue<>((x,y) -> Long.compare((long)x.num*y.den, (long)x.den*y.num));

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                pq.add(new Pair(arr[i],arr[j]));
            }
        }
        while(k-->1){
            pq.poll();
        }
        return new int[]{pq.peek().num,pq.peek().den};
    }
}