public class ValidBST {
    public boolean isValidBST(TreeNode root) {

        return isValid(root, -1002, 1002);
    }

    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true; // An empty tree is valid.
        }

        // Check if the current node violates the BST property.
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check the left and right subtrees with updated ranges.
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
