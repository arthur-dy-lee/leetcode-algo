package arthur.dy.lee.algo.test;

import arthur.dy.lee.algo.common.TreeNode;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        TreeNode root = node;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println("4,2,6,5,7,1,3".equals(node1.inorderTraversal()));
        System.out.println(JSONUtil.toJsonStr(node1.inorderTraversalReturList())
                .equals(JSONUtil.toJsonStr(Test1.inorderTraversal(node1))));
    }

}
