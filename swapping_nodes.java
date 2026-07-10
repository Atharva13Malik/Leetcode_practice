class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        // kth node from beginning
        for (int i = 1; i < k; i++) {
            temp = temp.next;
            fast = fast.next;
        }

        // kth node from end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int x = temp.val;
        temp.val = slow.val;
        slow.val = x;

        return head;
    }
}
