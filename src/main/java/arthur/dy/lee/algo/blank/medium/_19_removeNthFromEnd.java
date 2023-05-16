package arthur.dy.lee.algo.blank.medium;

import arthur.dy.lee.algo.common.ListNode;

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
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class _19_removeNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(_19_removeNthFromEnd.removeNthFromEnd(head, 2));

        head = ListNode.buildListNode(new int[] { 1 });
        System.out.println(_19_removeNthFromEnd.removeNthFromEnd(head, 1));

        head = ListNode.buildListNode(new int[] { 1, 2 });
        System.out.println(_19_removeNthFromEnd.removeNthFromEnd(head, 1));
    }
}
