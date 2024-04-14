package arthur.dy.lee.algo.classify.recursion;

import arthur.dy.lee.algo.common.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class _24_swapPairs_2 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode n1 = tmp.next;
            ListNode n2 = tmp.next.next;
            tmp.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            tmp = n1;
        }
        return dummy.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[] { 1, 2, 3, 4 });
        System.out.println(_24_swapPairs_2.swapPairs(head));
        head = null;
        System.out.println(_24_swapPairs_2.swapPairs(head));
        head = ListNode.buildListNode(new int[] { 1 });
        System.out.println(_24_swapPairs_2.swapPairs(head));
    }

}

/**
 * 具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
 * <p>
 * temp.next = node2
 * node1.next = node2.next
 * node2.next = node1
 * 完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
 */
