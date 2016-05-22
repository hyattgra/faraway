public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;

        for (int i = 0; i < lenS + 1; i++) {
            for (int j = 1; j < lenP + 1; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1]
                            && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
                } else {
                    dp[i][j] = (j > 1 && dp[i][j - 2]) ||
                            (i > 0 && dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
            }
        }

        return dp[lenS][lenP];
    }
