package arthur.dy.lee.common;

public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] initial) {
        if (initial == null || initial.length == 0) {
            return new ListNode();
        }
        ListNode pre = new ListNode();
        ListNode cur = pre;

        for (int i = 0; i < initial.length; i++) {
            ListNode tmp = new ListNode(initial[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        return pre.next;

    }

    @Override public String toString() {
        StringBuilder ret = new StringBuilder(8);
        ListNode head = this;

        if (head.next == null) {
            return Integer.toString(head.val);
        }
        while (head != null) {
            ret.append(head.val).append("->");
            head = head.next;
        }

        if (ret.length() > 1) {
            ret = ret.delete(ret.length() - 2, ret.length());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[] { 2, 4, 6, 8 });
        System.out.println(l1);
    }
}
