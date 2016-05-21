public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int num = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[num]) {
                num++;
                nums[num] = nums[i];
            }
        }
        return num + 1;
    }
