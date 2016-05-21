public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        if (cur != null && cur.next != null) {
            tmp = cur.next;
            cur.next = swapPairs(tmp.next);
            tmp.next = cur;
        }
        return tmp != null ? tmp : cur;

    }
