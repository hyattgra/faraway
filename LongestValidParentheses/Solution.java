public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int ret = 0;

        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                dp[i] = 0;
            } else {
                int j = (i + 1) + dp[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = 2 + dp[i + 1];
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j + 1];
                    }
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;

    }
