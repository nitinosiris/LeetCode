public class IsSubTreeSame {

    public class Solution {

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null || subRoot == null) {
                return false;
            }

            // Check if subRoot is a subtree of root by comparing root and subRoot directly
            if (isSameTree(root, subRoot)) {
                return true;
            }

            // Recursively check left and right subtrees
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        // Helper function to compare if two trees are identical
        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }

            if (s == null || t == null) {
                return false;
            }

            // Compare values of the nodes and recursively check left and right subtrees
            return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}