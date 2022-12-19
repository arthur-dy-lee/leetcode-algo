package arthur.dy.lee.best.medium;

import arthur.dy.lee.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class _19_removeNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return new ListNode();
        }
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode result = _19_removeNthFromEnd.removeNthFromEnd(head, 2);
        System.out.println(result);

        head = ListNode.buildListNode(new int[] { 1 });
        result = _19_removeNthFromEnd.removeNthFromEnd(head, 1);
        System.out.println(result);

        head = ListNode.buildListNode(new int[] { 1, 2 });
        result = _19_removeNthFromEnd.removeNthFromEnd(head, 1);
        System.out.println(result);
    }
}
