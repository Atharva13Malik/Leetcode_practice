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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk=new Stack<>();
        ListNode temp=head;

        while(temp!=null){
           
                while(!stk.isEmpty() && (temp.val>stk.peek().val)){
                    stk.pop();
                }

            
            stk.push(temp);
            temp=temp.next;
        }

        ListNode prev=null;

        while(!stk.isEmpty()){
            ListNode top=stk.pop();
            top.next=prev;
            prev=top;
        }

        return prev;


    }
}
