public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        helper(ret, new ArrayList<>(), nums);

        return ret;
    }

    private static void helper(List<List<Integer>> ret, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                helper(ret, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
