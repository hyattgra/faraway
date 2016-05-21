public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;

        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                cur = reverse(cur, head.next);
                head = cur.next;

            }else{
                head = head.next;
            }
        }

        return newHead.next;
    }

    private static ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = head.next;
        ListNode cur = pre.next;

        while (cur != end) {
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = pre.next;
        }

        return pre;
    }
