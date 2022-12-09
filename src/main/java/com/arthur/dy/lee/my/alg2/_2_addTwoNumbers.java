package com.arthur.dy.lee.my.alg2;

import com.arthur.dy.lee.common.ListNode;

public class _2_addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int h = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int temp = x + y + h;
            h = temp > 9 ? 1 : 0;
            temp = temp % 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr.next = new ListNode(temp);
            curr = curr.next;
        }
        if (h == 1) {
            curr.next = new ListNode(h);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[] { 9, 9, 9, 9, 9, 9 });
        ListNode l2 = ListNode.buildListNode(new int[] { 9, 9, 9 });
        ListNode ret = _2_addTwoNumbers.addTwoNumbers(l1, l2);
        //        ListNode l1 = ListNode.buildListNode(new int[] { 2, 4, 6, 8 });
        System.out.println(ret);
    }

}
