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
    public int[] nextLargerNodes(ListNode head) {
        int n = length(head);
        int[] copy = new int[n];
        ListNode temp = head;
        int idx=0;
        while(temp!=null){
            copy[idx++]=temp.val;
            temp=temp.next;
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            int el=copy[i];
            while(!st.isEmpty() && el>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }else{
                ans[i]=st.peek();
            }
            st.push(el);
        }
        return ans;
    }
}