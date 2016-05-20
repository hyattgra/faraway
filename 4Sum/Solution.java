  public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int ii = i + 1; ii < nums.length - 2; ii++) {
                for (int j = ii + 1, k = nums.length - 1; j < k; ) {
                    int tmp = nums[i] + nums[ii] + nums[j] + nums[k];
                    if (tmp == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[ii], nums[j], nums[k]);
                        if (!ret.contains(list)) {
                            ret.add(Arrays.asList(nums[i], nums[ii], nums[j], nums[k]));
                        }
                        j++;
                        k--;
                        while (j < k && nums[j - 1] == nums[j]) {
                            j++;
                        }
                        while (j < k && nums[k + 1] == nums[k]) {
                            k--;
                        }
                    } else if (tmp > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

        }
        return ret;
    }
