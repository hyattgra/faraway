int carry = 0;
        int remain = 0;
        ListNode cur1 = new ListNode(-1);
        ListNode head = cur1;

        while (l1!= null && l2!= null) {
            int tmp = l1.val + l2.val + carry;
            carry = tmp / 10;
            remain = tmp % 10;
            cur1.next = new ListNode(remain);
            cur1 = cur1.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1!= null) {
            while (l1!= null) {
                int tmp = l1.val + carry;
                carry = tmp / 10;
                remain = tmp % 10;
                cur1.next = new ListNode(remain);
                cur1 = cur1.next;
                l1 = l1.next;
            }
        }

        if (l2!= null)  {
            while (l2!= null) {
                int tmp = l2.val + carry;
                carry = tmp / 10;
                remain = tmp % 10;
                cur1.next = new ListNode(remain);
                cur1 = cur1.next;
                l2 = l2.next;
            }
        }

        if(carry!=0){
            cur1.next = new ListNode(carry);
        }
        return head.next;
