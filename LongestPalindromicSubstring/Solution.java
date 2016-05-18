public String longestPalindrome(String s) {
        String ret = "";

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            String tmp = helper(s, i, i);
            if (tmp.length() > ret.length()) {
                ret = tmp;
            }

            tmp = helper(s, i, i+1);
            if (tmp.length() > ret.length()) {
                ret = tmp;
            }
        }
        return ret;
    }


    private String helper(String S, int start, int end) {
        while (start >= 0 && end < S.length() && S.charAt(start) == S.charAt(end)) {
            start--;
            end++;
        }
        return S.substring(start + 1, end);
    }
