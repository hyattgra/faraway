public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] row = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i ++) {
            if (matrix[0][i] == '1') {
                row[i] = 1;
            }
        }
        int width = matrix[0].length;
        int max = largestRectangleArea(row);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        row[j] += 1;
                    } else {
                        row[j] = 1;
                    }
                } else {
                    row[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(row));
        }
        return max;
    }

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
