List<Integer> ret = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (Integer i : nums1) {
            ret.add(i);
        }

        for (Integer i : nums2) {
            if (ret.contains(i) && !res.contains(i)) {
                res.add(i);
            }
        }
        int[] t = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            t[i] = res.get(i);
        }
        return t;
