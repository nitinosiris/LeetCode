public class Diameter {
    private int MaxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        diameter(root);
        return MaxDiameter;
    }

    private int diameter(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        MaxDiameter = Math.max(left + right, MaxDiameter);
        return 1 + Math.max(left , right);
    }
}
