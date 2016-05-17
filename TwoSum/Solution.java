public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int[] local = nums.clone();
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i] + nums[j];
            if (tmp < target) {
                i++;
            } else if (tmp > target) {
                j--;
            } else {
                List<Integer> r1 = find(local, nums[i]);
                List<Integer> r2 = find(local, nums[j]);
                if (r1.size() == 1 && r2.size() == 1) {
                    ret[0] = r1.get(0);
                    ret[1] = r2.get(0);
                } else if (r1.size() > 1) {
                    ret[0] = r1.get(0);
                    ret[1] = r1.get(1);
                } else if (r2.size() > 1) {
                    ret[0] = r2.get(0);
                    ret[1] = r2.get(1);
                }

                return ret;
            }
        }
        return ret;
    }

    private List<Integer> find(int[] nums, int x) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                ret.add(i);
            }
        }
        return ret;
    }
}
