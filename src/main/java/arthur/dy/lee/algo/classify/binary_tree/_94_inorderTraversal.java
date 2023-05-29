package arthur.dy.lee.algo.classify.binary_tree;

import arthur.dy.lee.algo.common.TreeNode;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 简单
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例 1：
 * 图片可看README.md文件
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/412886/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
 */
public class _94_inorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static List<Integer> inorderTraversal2_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 方法三：Morris 中序遍历
     * 思路与算法
     * <p>
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)O(1)O(1)。
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xxx）：
     * <p>
     * 如果 xxx 无左孩子，先将 xxx 的值加入答案数组，再访问 xxx 的右孩子，即 x=x.rightx = x.\textit{right}x=x.right。
     * 如果 xxx 有左孩子，则找到 xxx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xxx 在中序遍历中的前驱节点），我们记为 predecessor\textit{predecessor}predecessor。根据 predecessor\textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
     * 如果 predecessor\textit{predecessor}predecessor 的右孩子为空，则将其右孩子指向 xxx，然后访问 xxx 的左孩子，即 x=x.leftx = x.\textit{left}x=x.left。
     * 如果 predecessor\textit{predecessor}predecessor 的右孩子不为空，则此时其右孩子指向 xxx，说明我们已经遍历完 xxx 的左子树，我们将 predecessor\textit{predecessor}predecessor 的右孩子置空，将 xxx 的值加入答案数组，然后访问 xxx 的右孩子，即 x=x.rightx = x.\textit{right}x=x.right。
     * 重复上述操作，直至访问完整棵树。
     */
    public static List<Integer> inorderTraversal3_morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
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

        System.out.println("4,2,6,5,7,1,3".equals(node1.inorderTraversal()));
        System.out.println(JSONUtil.toJsonStr(node1.inorderTraversalReturList())
                .equals(JSONUtil.toJsonStr(_94_inorderTraversal.inorderTraversal2_iter(node1))));
    }
}
