package arthur.dy.lee.algo.common;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历，返回字符串
     *
     * @return
     */
    public String preorderTraversal() {
        StringBuilder res = new StringBuilder();
        if (this == null) {
            return res.toString();
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = this;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.append(node.val).append(",");
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        if (res != null && res.length() > 1) {
            return res.deleteCharAt(res.length() - 1).toString();
        }
        return res.toString();

    }

    //    public String preorderTraversal2() {
    //        StringBuilder res = new StringBuilder();
    //        TreeNode root = this;
    //        if (root == null) {
    //            return res.toString();
    //        }
    //        Deque<TreeNode> stack = new LinkedList<>();
    //        stack.push(root);
    //        while (!stack.isEmpty()) {
    //            TreeNode tmp = stack.pop();
    //            if (tmp != null) {
    //                res.append(tmp.val).append(",");
    //                stack.push(tmp.right);
    //                stack.push(tmp.left);
    //            } else {
    //                if (!stack.isEmpty()) {
    //                    stack.pop();
    //                }
    //            }
    //        }
    //        if (res != null && res.length() > 1) {
    //            return res.deleteCharAt(res.length() - 1).toString();
    //        }
    //        return res.toString();
    //    }

    public List<Integer> preorderTraversalReturnList() {
        TreeNode root = this;
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * 中序遍历，返回字符串
     *
     * @return
     */
    public String inorderTraversal() {
        StringBuilder res = new StringBuilder();
        inorder(this, res);
        if (res != null && res.length() > 1) {
            return res.deleteCharAt(res.length() - 1).toString();
        }
        return res.toString();
    }

    public void inorder(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.append(root.val).append(",");
        inorder(root.right, res);
    }

    public String inorderTraversal2() {
        StringBuilder res = new StringBuilder();
        TreeNode root = this;
        if (root == null) {
            return res.toString();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            int tmpVal = tmp != null ? tmp.val : -1;
            if (tmp != null) {
                stack.push(tmp.right);
                stack.push(tmp);
                stack.push(tmp.left);
            } else {
                if (!stack.isEmpty()) {
                    res.append(stack.pop().val).append(",");
                }
            }
        }
        if (res != null && res.length() > 1) {
            return res.deleteCharAt(res.length() - 1).toString();
        }
        return res.toString();
    }

    public List<Integer> inorderTraversalReturList() {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode root = this;
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
     * 后序遍历，返回字符串
     *
     * @return
     */
    public String postorderTraversal() {
        TreeNode root = this;
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.toString();
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.append(root.val).append(",");
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        if (res != null && res.length() > 1) {
            return res.deleteCharAt(res.length() - 1).toString();
        }
        return res.toString();
    }

    /*public String postorderTraversal2() {
        StringBuilder res = new StringBuilder();
        TreeNode root = this;
        if (root == null) {
            return res.toString();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                stack.push(tmp);
                stack.push(tmp.right);
                stack.push(tmp.left);
            } else {
                if (!stack.isEmpty()) {
                    while (stack.peek() == null) {
                        stack.pop();
                    }
                    res.append(stack.pop().val).append(",");
                }
            }
        }
        if (res != null && res.length() > 1) {
            return res.deleteCharAt(res.length() - 1).toString();
        }
        return res.toString();
    }*/

    public List<Integer> postorderTraversalReturList() {
        TreeNode root = this;
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
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

        System.out.println("1,2,4,5,6,7,3".equals(node1.preorderTraversal()));
        //        System.out.println("1,2,4,5,6,7,3".equals(node1.preorderTraversal2()));
        //        System.out.println("4,2,6,5,7,1,3".equals(node1.inorderTraversal()));
        System.out.println("4,2,6,5,7,1,3".equals(node1.inorderTraversal2()));
        System.out.println("4,6,7,5,2,3,1".equals(node1.postorderTraversal()));
        //        System.out.println("4,6,7,5,2,3,1".equals(node1.postorderTraversal2()));
        //        System.out.println(node1.postorderTraversal2());
    }

}
