import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Use a stack to simulate the recursion
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Push children to the stack if they are not null
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return root;
    }
}
