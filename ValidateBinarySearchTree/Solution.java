public boolean isValidBST(TreeNode root) {
        return isHelper(root, Double.NEGATIVE_INFINITY,  Double.POSITIVE_INFINITY);
    }

    private boolean isHelper(TreeNode root, double min, double max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isHelper(root.left, min, root.val) && isHelper(root.right, root.val, max);
    }
