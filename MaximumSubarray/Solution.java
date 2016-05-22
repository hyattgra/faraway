public int maxSubArray(int[] nums) {
        int curSum = 0;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (curSum > 0) {
                curSum += nums[i];
            }
            if (curSum <= 0) {
                curSum = nums[i];
            }
            ret = Math.max(ret, curSum);
        }

        return ret;
    }
