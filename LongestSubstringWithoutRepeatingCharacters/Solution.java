public static int lengthOfLongestSubstring(String s) {

        int ret = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ret = Math.max(ret, i - j);
                while (s.charAt(i) != s.charAt(j)) {
                    map.remove(s.charAt(j));
                    j++;
                }
                j++;
            } else {
                map.put(s.charAt(i), i);
            }
        }
        ret = Math.max(ret, i - j);
        return ret;
    }
