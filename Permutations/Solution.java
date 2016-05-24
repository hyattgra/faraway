public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        helper(ret, new ArrayList<>(), nums, used);
        return ret;
    }

    private static void helper(List<List<Integer>> ret, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tmp.add(nums[i]);
                helper(ret, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
