public class LCa {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return check(root, p, q);
    }

    private TreeNode check(TreeNode node, TreeNode n1, TreeNode n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA
        // lies in left
        if (node.val > n1.val && node.val > n2.val)
            return check(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA
        // lies in right
        if (node.val < n1.val && node.val < n2.val)
            return check(node.right, n1, n2);

        return node;
    }
}
