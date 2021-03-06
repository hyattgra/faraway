public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
