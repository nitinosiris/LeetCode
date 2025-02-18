import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    Queue<TreeNode> queue;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root != null)
        {
            queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                int levelSize = queue.size(); // 2^i
                List<Integer> temp = new ArrayList<>();
                int j = 0;

                while(j < levelSize && !queue.isEmpty())
                {
                    var node = queue.poll();
                    temp.add(node.val);
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                    j++;
                }
                res.add(temp.getLast());
            }
        }
        return res;
    }
}
