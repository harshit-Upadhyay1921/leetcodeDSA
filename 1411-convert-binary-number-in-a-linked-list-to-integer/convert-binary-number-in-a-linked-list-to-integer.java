/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
    public int getDecimalValue(ListNode head) {
        int len=length(head);
        ListNode temp=head;
        int sum=0;
        len--;
        while(temp!=null){
            sum+=(temp.val*Math.pow(2,len--));
            temp=temp.next;
        }
        return sum;
    }
}