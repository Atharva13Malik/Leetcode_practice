class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head==null || head.next==null || k==0){
        return head;
      }
      int length=1;
      ListNode temp=head;
      while(temp.next!=null){
        temp=temp.next;
        length++;

      }

      temp.next=head;  // circluar bnngyi list
      k=k%length;


      int steps=length-k;

      ListNode newtail=temp;
      while(steps-- >0){
        newtail=newtail.next;
       // steps--;
      }

      //break circle
      ListNode newHead=newtail.next;
      newtail.next=null;
      return newHead;
      
    }
}
