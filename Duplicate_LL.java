class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode i=head;
        ListNode j=head;

        while(j!=null ){
            if(i.val!=j.val){
                i.next=j;
                i=j;
            }
            j=j.next;
        }
        i.next=j;
        return head;
    }
}
