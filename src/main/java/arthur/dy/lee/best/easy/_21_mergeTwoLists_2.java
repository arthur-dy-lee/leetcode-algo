package arthur.dy.lee.best.easy;

import arthur.dy.lee.common.ListNode;


/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class _21_mergeTwoLists_2 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        l1 = ListNode.buildListNode(new int[] { 1, 2, 4, 5 });
        l2 = ListNode.buildListNode(new int[] { 1, 4, 7 });
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));

        l1 = ListNode.buildListNode(new int[] { 1, 2, 4 });
        l2 = ListNode.buildListNode(new int[] { 1, 3, 4 });
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));

        l1 = null;
        l2 = null;
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));

        l1 = new ListNode();
        l2 = new ListNode();
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));

        l1 = ListNode.buildListNode(new int[] {});
        l2 = ListNode.buildListNode(new int[] {});
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));

        l1 = ListNode.buildListNode(new int[] { 1 });
        l2 = ListNode.buildListNode(new int[] { 0 });
        System.out.println(_21_mergeTwoLists_2.mergeTwoLists(l1, l2));
    }

}
