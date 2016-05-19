public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            ret = Math.max(ret, (right - left) * Math.min(height[left], height[right]));
            if (Math.min(height[left], height[right]) == height[left]) {
                left++;
            }else {
                right--;
            }
        }
        return ret;
    }
