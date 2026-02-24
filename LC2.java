class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode a=new ListNode(-1);
        ListNode temp=a;
        int carry=0;

        while(temp1!=null || temp2!=null || carry!=0){
            int val1=(temp1==null)?0:temp1.val;
            int val2=(temp2==null)?0:temp2.val;
            int value=val1+val2+carry;
             
            ListNode b=new ListNode(value%10);
            carry=value/10;
           

            if(b!=null){
                temp.next=b;
                temp=temp.next;
                
            }else{
                temp=b;
            }

           temp1=(temp1==null)?null:temp1.next;
           temp2=(temp2==null)?null:temp2.next;
            

        }
        return a.next;
    }
}
