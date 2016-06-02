public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int retSize = ret.size();
            for (int j = 0; j < retSize; j++) {
                List<Integer> tmp = new ArrayList<Integer>(ret.get(j));
                tmp.add(nums[i]);
                ret.add(tmp);
            }
            List<Integer> oneNum = new ArrayList<Integer>();
            oneNum.add(nums[i]);
            ret.add(oneNum);
        }
        ret.add(0, new ArrayList<Integer>());
        return ret;
    }
