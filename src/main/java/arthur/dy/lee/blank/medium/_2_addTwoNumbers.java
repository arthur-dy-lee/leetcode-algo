package arthur.dy.lee.blank.medium;

import arthur.dy.lee.common.ListNode;

public class _2_addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

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
