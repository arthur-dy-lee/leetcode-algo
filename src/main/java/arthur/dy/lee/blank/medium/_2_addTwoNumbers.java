package arthur.dy.lee.blank.medium;

import arthur.dy.lee.common.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 2->4->3
 * 5->6->4
 * 7->0->8
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class _2_addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        ListNode head = new ListNode();
        ListNode res = new ListNode();
        head.next = res;
        int count = 0;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + count;
            } else if (l1 == null) {
                val = l2.val + count;
            } else if (l2 == null) {
                val = l1.val + count;
            }

            if (val >= 10) {
                count = 1;
                val = val % 10;
            } else {
                count = 0;
            }
            res.next = new ListNode(val);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            res = res.next;
        }
        if (count == 1) {
            res.next = new ListNode(1);
        }
        return head.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[] { 2, 4, 3 });
        ListNode l2 = ListNode.buildListNode(new int[] { 5, 6, 4 });
        ListNode ret = _2_addTwoNumbers.addTwoNumbers(l1, l2);
        ListNode ans = ListNode.buildListNode(new int[] { 7, 0, 8 });
        System.out.println(ret.toString().equals(ans.toString()));

        l1 = ListNode.buildListNode(new int[] { 0 });
        l2 = ListNode.buildListNode(new int[] { 0 });
        ret = _2_addTwoNumbers.addTwoNumbers(l1, l2);
        ans = ListNode.buildListNode(new int[] { 0 });
        System.out.println(ret.toString().equals(ans.toString()));

        l1 = ListNode.buildListNode(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        l2 = ListNode.buildListNode(new int[] { 9, 9, 9, 9 });
        ret = _2_addTwoNumbers.addTwoNumbers(l1, l2);
        ans = ListNode.buildListNode(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });
        System.out.println(ret.toString().equals(ans.toString()));
    }

}
