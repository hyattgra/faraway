public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        int[] local = Arrays.copyOf(nums, nums.length);
        Arrays.sort(local);
        boolean[] used = new boolean[nums.length];
        helper(ret, new ArrayList<>(), local, used);

        return ret;
    }

    private static void helper(List<List<Integer>> ret, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            helper(ret, tmp, nums, used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }
