public class KthSmallestInBSE {
    private int ans;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        ans = -1;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null || count == 0)
            return;

        inorder(root.left);  // Traverse left subtree

        count--;  // Process current node
        if (count == 0) {
            ans = root.val;
            return;  // Stop recursion early
        }

        inorder(root.right);  // Traverse right subtree
    }
}
