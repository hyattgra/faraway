public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int lHay = haystack.length();
        int lNeedle = needle.length();

        for (int i = 0; i < lHay - lNeedle + 1; i++) {
            int idx = 0;
            while (idx < lNeedle && haystack.charAt(i + idx) == needle.charAt(idx)) {
                idx++;
            }

            if (idx == lNeedle) {
                return i;
            }
        }
        return -1;
    }
