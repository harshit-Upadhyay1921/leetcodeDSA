/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node find(Node head){
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        return tail;
    }
    public Node flatten(Node head) {
        Node temp=head;
        while(temp!=null){
            if(temp.child!=null){
                Node laterNode = temp.next;
                if(laterNode!=null) laterNode.prev = null;//temp.next.prev = null;
                Node ans = flatten(temp.child);
                temp.next = ans;
                ans.prev = temp;
                temp.child = null;
                //find the tail
                Node tail = find(temp.next);
                tail.next = laterNode;
                if(laterNode!=null) laterNode.prev = tail;
                temp=tail;

            }
            temp=temp.next;
        }
        return head;
    }
}