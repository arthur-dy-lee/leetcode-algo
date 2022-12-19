package arthur.dy.lee.best;

import arthur.dy.lee.best.easy._21_mergeTwoLists_2;
import arthur.dy.lee.common.ListNode;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class _21_mergeTwoLists_2Test {

    @Autowired
    private _21_mergeTwoLists_2 mergeTwoLists;

    @Test
//    @Tag(" 成功 ")
    void succeedingTest() {
        ListNode l1 = null;
        ListNode l2 = null;
        l1 = ListNode.buildListNode(new int[] { 1, 2, 4 });
        l2 = ListNode.buildListNode(new int[] { 1, 3, 4 });
        ListNode result = mergeTwoLists.mergeTwoLists(l1, l2);
        ListNode target = ListNode.buildListNode(new int[] { 1, 1, 2, 3, 4, 4 });
        Assert.assertEquals(result.toString(), target.toString());
    }
}
