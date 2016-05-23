public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int[] height = Arrays.copyOf(heights, heights.length + 1);
        int ret = 0;
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ret = Math.max(ret, width * height[idx]);
            }
        }

        return ret;
    }
