private TreeNode pre = null;
    private TreeNode post = null;
    private TreeNode current = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = pre.val;
        pre.val = post.val;
        post.val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        if (current != null && node.val < current.val) {
            if (pre == null) {
                pre = current;
            }
            post = node;
        }
        current = node;
        inorder(node.right);
    }
