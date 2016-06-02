 public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(ret, new ArrayList<Integer>(), k, n, 0);
        return ret;
    }

    private static void helper(List<List<Integer>> ret, List<Integer> tmp, int k, int n, int index) {
        if (tmp.size() == k) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            tmp.add(i);
            helper(ret, tmp, k, n, i);
            tmp.remove(tmp.size() - 1);

        }
    }
