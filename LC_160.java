public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int len1=0;
        int len2=0;

        while(temp1!=null){
            len1++;
            temp1=temp1.next;

        }

        while(temp2!=null){
            len2++;
            temp2=temp2.next;
        }

        temp1=headA;
        temp2=headB;

        if(len1>len2){
            for(int i=0;i< len1-len2 ;i++){
                temp1=temp1.next;
            }
        }

         if(len2>len1){
            for(int i=0;i< len2-len1 ;i++){
                temp2=temp2.next;
            }
        }

        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return temp1;
    }
}
