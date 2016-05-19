public String convert(String s, int numRows) {
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ret.add(new ArrayList<>());
        }
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < numRows && count < s.length(); i++) {
                ret.get(i).add(s.charAt(count) + "");
                count++;
            }
            for (int i = numRows - 2; i >= 1 && count < s.length(); i--) {
                ret.get(i).add(s.charAt(count) + "");
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> list : ret) {
            for (String s1 : list) {
                sb.append(s1);
            }
        }
        return sb.toString();
    }
