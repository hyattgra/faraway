 public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int counter = 0;

        while (fast.next!=null) {
            if(counter>=n){
                slow = slow.next;
            }
            counter++;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
