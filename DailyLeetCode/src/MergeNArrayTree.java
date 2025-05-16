import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeNArrayTree {
    class Node {
        String name;
        String value;
        List<Node> childs;

        Node(String n, String val) {
            name = n;
            value = val;
            childs = new ArrayList<>();
        }
    }

    public Node merge(Node n1, Node n2) {
        return mergeRec(n1, n2);
    }

    private Node mergeRec(Node n1, Node n2) {
        if (n1.name.equals(n2.name)) {
            Node merged = new Node(n1.name, n2.value);

            Map<String, Node> t2Map = new HashMap<>();
            for (Node child : n2.childs) {
                t2Map.put(child.name, child);
            }

            List<Node> mergedChildren = new ArrayList<>();

            for (Node child1 : n1.childs) {
                if (t2Map.containsKey(child1.name)) {
                    Node mergedChild = mergeRec(child1, t2Map.get(child1.name));
                    mergedChildren.add(mergedChild);
                    t2Map.remove(child1.name);
                } else {
                    mergedChildren.add(child1);
                }
            }

            for (Node child2 : n2.childs) {
                if (t2Map.containsKey(child2.name)) {
                    mergedChildren.add(child2);
                }
            }

            merged.childs = mergedChildren;
            return merged;
        } else {
            Node newnode = new Node(n2.name, n2.value);
            newnode.childs.add(n1);
            newnode.childs.add(n2);
            return newnode;
        }
    }
}
