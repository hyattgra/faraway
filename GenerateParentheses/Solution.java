public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0 || n == 2) {
            return ret;
        }

        helper(ret, n, n, "");
        return ret;
    }

    private static void helper(List<String> ret, int leftNeed, int rightNeed, String tmp) {
        if (leftNeed == 0 && rightNeed == 0) {
            ret.add(tmp);
        } else {
            if (leftNeed > 0) {
                helper(ret, leftNeed - 1, rightNeed, tmp + "(");
            }
            if (rightNeed > leftNeed) {
                helper(ret, leftNeed, rightNeed - 1, tmp + ")");
            }
        }
    }
