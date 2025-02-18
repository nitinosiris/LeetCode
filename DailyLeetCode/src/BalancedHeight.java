public class BalancedHeight {
    private boolean check = false;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return !check;
    }

    private int height(TreeNode root)
    {
        if(!check)
        {
            if(root == null)
                return 0;
            if(root.left == null && root.right == null)
                return 1;

            int left = height(root.left);
            int right = height(root.right);

            if(Math.abs(left - right) > 1)
                check = true;

            return 1 + Math.max(left, right);
        }
        return -1;
    }
}
