import java.util.HashMap;

public class LRUCache {
    class ListNode {
        int key, value;
        ListNode prev, next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        private final int capacity;
        private final HashMap<Integer, ListNode> map;
        private final ListNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();

            // Dummy head and tail to simplify boundary conditions
            this.head = new ListNode(-1, -1);
            this.tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            ListNode node = map.get(key);
            moveToHead(node);  // Mark this node as recently used
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                node.value = value;  // Update the value
                moveToHead(node);
            } else {
                if (map.size() == capacity) {
                    removeLRU();
                }
                ListNode newNode = new ListNode(key, value);
                addToHead(newNode);
                map.put(key, newNode);
            }
        }

        private void moveToHead(ListNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(ListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }


        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeLRU() {
            ListNode lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
}
