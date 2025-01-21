public class GoodNodes {
    int count = 0;
    public int goodNodes(TreeNode root) {
        check(root, root.val);
        return count;
    }

    private void check(TreeNode root, int max)
    {
        if(root != null)
        {
            if(root.val >= max)
                count++;

            var mx = Math.max(root.val, max);
            check(root.left, mx);
            check(root.right, mx);
        }
    }
}
