public static List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put("0", " ");
        List<String> ret = new ArrayList<>();
        if(digits.length()==0){
            return ret;
        }
        helper(new StringBuilder(), 0, ret, digits, map);
        return ret;
    }

    private static void helper(StringBuilder sb, int idx, List<String> ret, String digits, Map<String, String> map) {
        if (idx == digits.length()-1) {
            char[] chars = map.get(digits.charAt(idx) + "").toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int size = sb.length();
                char c = chars[i];
                sb.append(c);
                ret.add(sb.toString());
                sb.setLength(size);
            }
            return;
        }
        char[] chars = map.get(digits.charAt(idx) + "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int size = sb.length();
            char c = chars[i];
            sb.append(c);
            helper(sb, idx + 1, ret, digits, map);
            sb.setLength(size);
        }

    }
