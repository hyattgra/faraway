public boolean isScramble(String s1, String s2) {

        int len = s1.length();

        if (len == 1) {
            return s1.equals(s2);
        }

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String s1Sorted = new String(s1Arr);

        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        String s2Sorted = new String(s2Arr);

        if (!s1Sorted.equals(s2Sorted)) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &
                    isScramble2(s1.substring(i, len), s2.substring(i, len))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) &&
                    isScramble2(s1.substring(i, len), s2.substring(0, len - i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();

        boolean[][][] dp = new boolean[len][len][len + 1];

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }

                    dp[i][j][k] = false;
                    for (int m = 1; m < k; m++) {
                        if (dp[i][j][m] && dp[i + m][j + m][k - m]
                                || dp[i + m][j][k - m] && dp[i][j + k - m][m]) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][len];
    }
