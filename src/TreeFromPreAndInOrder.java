import java.util.HashMap;

public class TreeFromPreAndInOrder {
    private int preOrderIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        return createTree(preorder, 0, inorder.length - 1);

    }

    private TreeNode createTree(int[] preOrder, int inOrderStart, int inOrderEnd)
    {
        // if no element in curr subtree
        if(inOrderStart > inOrderEnd)
            return null;

        // Get the root value from the current preorder index
        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // get the index of rootvalue
        int index = map.get(rootValue);

        // recursively create left and right
        root.left = createTree(preOrder, inOrderStart, index - 1);
        root.right = createTree(preOrder, index + 1, inOrderEnd);

        return root;
    }
}
