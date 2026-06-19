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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode N=new ListNode(100);  //ek temporary node jisme hmne 100 value di h 
       ListNode temp=N;

        ListNode t1=list1;
        ListNode t2=list2;

        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }else{
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            }
        } 
        if(t2==null){
            temp.next=t1;
        }else{
            temp.next=t2;
        }
        return N.next;
    }
}
