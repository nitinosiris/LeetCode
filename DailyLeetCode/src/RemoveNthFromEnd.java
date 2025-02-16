public class RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            remove(head, n, dummy);
            return dummy.next;
        }

        private int remove(ListNode head, int n, ListNode prev)
        {
            if(head == null)
                return 0;

            int res = 1 + remove(head.next, n, head);
            if(res == n)
            {
                prev.next = head.next;
            }
            return res;
        }
    }
}
