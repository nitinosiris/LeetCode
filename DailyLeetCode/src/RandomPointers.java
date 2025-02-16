import java.util.HashMap;

public class RandomPointers {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        while(curr != null)
        {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr != null)
        {
            var node = map.get(curr);
            node.next = curr.next == null ? null : map.get(curr.next);
            node.random = curr.random == null ? null : map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
