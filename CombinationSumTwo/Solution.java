public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int[] local = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(local);

        helper(ret, new ArrayList<Integer>(), local, target, 0);
        return ret;
    }


    private static void helper(List<List<Integer>> ret, List<Integer> tmp, int[] nums,
                               int target, int start) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(ret, tmp, nums, target - nums[i], i + 1);
            tmp.remove(tmp.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i += 1;
            }

        }
    }
