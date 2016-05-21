public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists(Arrays.asList(lists));
    }

    private ListNode mergeKLists(List<ListNode> list) {
        if (list.size() == 2) {
            return mergeTwoLists(list.get(0), list.get(1));
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        int size = (list.size() - 1) / 2;
        ListNode headLeft = mergeKLists(list.subList(0, size + 1));
        ListNode headRight = mergeKLists(list.subList(size + 1, list.size()));

        return mergeTwoLists(headLeft, headRight);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummyHead.next;
    }
