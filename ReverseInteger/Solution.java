boolean neg = false;
        if (x < 0) {
            neg = true;
        }
        long y = neg ? (-1) * (long)x : (long)x;
        StringBuilder sb = new StringBuilder(String.valueOf(y));
        String reverse = sb.reverse().toString();
        int i = 0;
        while (i < reverse.length() && reverse.charAt(i) == '0') {
            i++;
        }
        if (i == reverse.length()) {
            return 0;
        }
        reverse = reverse.substring(i);
        Long longReverse = Long.parseLong(reverse);
        if (longReverse > Integer.MAX_VALUE) {
            return 0;
        }

        if (neg && -longReverse < Integer.MIN_VALUE) {
            return 0;
        }
        return neg ? -longReverse.intValue() : longReverse.intValue();
