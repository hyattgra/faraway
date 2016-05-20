public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        stack.push('*');
        stack.push(arr[0]);
        int i = 1;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('*', '*');

        while (!stack.isEmpty() && i < s.length()) {
            if (arr[i] != map.get(stack.peek())) {
                stack.push(arr[i]);
            } else {
                stack.pop();
            }
            i++;
        }

        return stack.size() == 1;
    }
