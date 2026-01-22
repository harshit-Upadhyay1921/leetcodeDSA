class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
class Solution {
    public boolean isSorted(Node head){
        if(head.next==null) return true;
        Node temp=head;
        while(temp.next!=null){
            if(temp.val>temp.next.val) return false;
            temp=temp.next;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        Node head = null;
        head = new Node(nums[0]);
        Node current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new Node(nums[i]);
            current = current.next;
        }

        int count=0;
        while(!isSorted(head)){
            int min=Integer.MAX_VALUE;
            int idx=0;
            int last=-1;
            Node temp=head;
            while(temp.next!=null){    // 1 100 2 -> 101 2
                int sum=temp.val+temp.next.val;
                if(sum<min){
                    min=sum;  //4 1 0 -1
                    last=idx; //0 1 4  9
                }
                idx++;
                temp=temp.next;
            }

            if(last==0){
                Node sumHeadNode = new Node(min);
                sumHeadNode.next = head.next.next;
                head = sumHeadNode;  //101 -> 103
            }
            else{
                temp=head;
                while(last-->1){
                    temp=temp.next;
                }
                //linking sum
                Node sumNode = new Node(min);
                sumNode.next=temp.next.next.next;
                temp.next=sumNode;
            }
            count++;
        }
        return count;
    }
}