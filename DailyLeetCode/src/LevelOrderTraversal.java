import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    Queue<TreeNode> queue;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

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
                res.add(temp);
            }
        }
        return res;
    }
}
