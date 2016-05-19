public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String c = strs[0].length() == 0 ? "" : strs[0].charAt(0) + "";
        int idx = 0;
        int i = 0;
        for (; i < strs.length; i++) {
            if (i == 0) {
                c = idx < strs[0].length() ? strs[0].charAt(idx) + "" : null;
            }
            String tmpC = idx < strs[i].length() ? strs[i].charAt(idx) + "" : null;
            if (c == null || tmpC == null) {
                return sb.toString();
            } else if (!c.equals(tmpC)) {
                return sb.toString();
            } else {
                if (i == strs.length - 1) {
                    idx++;
                    sb.append(tmpC);
                    i = -1;
                }
            }
        }
        return sb.toString();
    }
