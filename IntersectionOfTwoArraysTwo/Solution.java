public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                ret.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] res = new int[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }

        return res;
    }
