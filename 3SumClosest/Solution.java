public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - closet) > Math.abs(target - tmp)) {
                    closet = tmp;
                    if (closet == target) {
                        return closet;
                    }
                }
                if (tmp > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return closet;
    }
