package arthur.dy.lee.algo.answer.easy;

import arthur.dy.lee.algo.common.ColorNode;
import arthur.dy.lee.algo.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 简单
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 图片可看README.md文件
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 树中节点的数目在范围 [0, 100] 内
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
public class _145_postorderTraversal {

    /**
     * 栈迭代方法虽然提高了效率，但其嵌套循环却非常烧脑，不易理解，容易造成 “一看就懂，一写就废” 的窘况。而且对于不同的遍历顺序（前序、中序、后序），
     * 循环结构差异很大，更增加了记忆负担。
     * <p>
     * 因此，我在这里介绍一种 “颜色标记法” （瞎起的名字……），兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，
     * 这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
     * <p>
     * 其核心思想如下：
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     * <p>
     * 作者：henry
     * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/25220/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();


        return res;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
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

        List<Integer> list = _145_postorderTraversal.postorderTraversal2(node1);
        StringBuilder sb = new StringBuilder();
        for (Integer a : list) {
            sb.append(a).append(",");
        }
        String res = sb.deleteCharAt(sb.length() - 1).toString();
        System.out.println("res=" + res);
        System.out.println("4,6,7,5,2,3,1".equals(res));
    }
}
