public class MaxPathSUm {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int x = check(root);
        return Math.max(maxSum, x);
    }

    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate max path sums for left and right subtrees
        int l = check(root.left);
        int r = check(root.right);

        // Update the global maxSum to include the current node and both subtrees
        maxSum = Math.max(maxSum, Math.max(l + r + root.val, root.val));

        // Return the max single path sum (node + one subtree, or just the node)
        return Math.max(0, Math.max(l, r)) + root.val;
    }
}
