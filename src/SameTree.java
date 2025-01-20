public class SameTree {
    private boolean same = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        checkNodes(p, q);
        return same;
    }

    private void checkNodes(TreeNode p, TreeNode q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return;
        } else if (p == null || q == null) {
            same = false;
            return;
        }

        // Recursively check left and right subtrees
        checkNodes(p.left, q.left);
        checkNodes(p.right, q.right);

        // Check current node values
        if (p.val != q.val) {
            same = false;
        }
    }

    // TreeNode definition for clarity
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
