public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp == 0) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k + 1] == nums[k]) {
                        k--;
                    }
                } else if (tmp > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }
