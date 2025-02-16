public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        if(head.next != null)
        {
            // get the mid
            while(fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = reverse(slow.next);
            slow.next = null; // Break the first half

            // Merge two halves
            ListNode first = head;
            while (first != null && second != null) {
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;

                first.next = second;
                second.next = temp1;

                first = temp1;
                second = temp2;
            }
        }
    }

    private ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null)
        {
            var nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
