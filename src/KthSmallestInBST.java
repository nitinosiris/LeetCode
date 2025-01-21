public class KthSmallestInBST {
    private int ans = -1;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        reachTillCount(root, k);
        return ans;
    }

    private boolean reachTillCount(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        // Traverse the left subtree
        if (reachTillCount(root.left, k)) {
            return true;
        }

        // Increment count and check if this is the kth node
        count++;
        if (count == k) {
            ans = root.val;
            return true; // Stop further traversal
        }

        // Traverse the right subtree
        return reachTillCount(root.right, k);
    }
}
