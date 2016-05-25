public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        int[] cols = new int[n];
        helper(ret, 0, n, cols);
        return ret;
    }

    private static void helper(List<List<String>> ret, int rowNum, int n, int[] cols) {
        if (rowNum == n) {
            List<String> tmpRes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (cols[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                tmpRes.add(sb.toString());
            }

            ret.add(tmpRes);
            return;
        }

        for (int i = 0; i < n; i++) {
            cols[rowNum] = i;
            if (isValid(cols, rowNum)) {
                helper(ret, rowNum + 1, n, cols);
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
