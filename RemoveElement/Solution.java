public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int idx = 0;

        int j = -1;
        while (idx < nums.length) {
            if (nums[idx] != val) {
                j++;
                int temp = nums[idx];
                nums[idx] = nums[j];
                nums[j] = temp;
            }
            idx++;
        }
        return j + 1;
    }
