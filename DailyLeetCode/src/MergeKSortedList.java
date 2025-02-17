import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add all the list heads to the priority queue
        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
