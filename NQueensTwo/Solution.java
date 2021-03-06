public static int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] arr = new int[1];
        helper( 0, n, cols, arr);
        return arr[0];
    }


    private static void helper(int rowNum, int n, int[] cols, int[] arr) {
        if (rowNum == n) {
            arr[0] += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            cols[rowNum] = i;
            if (isValid(cols, rowNum)) {
                helper(rowNum + 1, n, cols, arr);
            }
        }
    }

    private static boolean isValid(int[] cols, int rowNum) {
        for (int i = 0; i < rowNum; i++) {
            if (cols[rowNum] == cols[i] || Math.abs(cols[rowNum] - cols[i]) == rowNum - i) {
                return false;
            }
        }
        return true;

    }
