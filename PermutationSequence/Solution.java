public static String getPermutation(int n, int k) {
        int[] facs = new int[n + 1];
        facs[0] = 1;
        for (int i = 1; i < n; i++) {
            facs[i] = facs[i - 1] * i;
        }
        List<Character> ret = new ArrayList<>();

        List<Character> unused = new ArrayList<Character>();
        for (int i = 0; i < n; i++) {
            unused.add(String.valueOf(i + 1).charAt(0));
        }

        for (int i = n; i >= 1; i--) {
            int j = (k - 1) / facs[i - 1];
            k -= j * facs[i - 1];
            ret.add(unused.get(j));
            unused.remove(j);
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : ret) {
            sb.append(c);
        }

        return sb.toString();
    }
