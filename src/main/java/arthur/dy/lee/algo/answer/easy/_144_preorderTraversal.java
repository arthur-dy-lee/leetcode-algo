package arthur.dy.lee.algo.answer.easy;

import arthur.dy.lee.algo.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 简单
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * 图片可看README.md文件
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 图片可看README.md文件
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * 图片可看README.md文件
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class _144_preorderTraversal {
    static class ColorNode {
        TreeNode node;
        String   color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            if (cn.color.equals("white")) {
                if (cn.node.right != null)
                    stack.push(new ColorNode(cn.node.right, "white"));
                if (cn.node.left != null)
                    stack.push(new ColorNode(cn.node.left, "white"));

                stack.push(new ColorNode(cn.node, "gray"));
            } else {
                res.add(cn.node.val);
            }
        }

        return res;
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (root != null || !stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                res.add(tmp.val);
            }

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        List<Integer> list = _144_preorderTraversal.preorderTraversal2(node1);
        StringBuilder sb = new StringBuilder();
        for (Integer a : list) {
            sb.append(a).append(",");
        }
        String res = sb.deleteCharAt(sb.length() - 1).toString();
        System.out.println("res=" + res);
        System.out.println("1,2,4,5,6,7,3".equals(res));
    }
}

