package arthur.dy.lee.algo.test;

public class Node<T> {

    public Node<T> left;
    public Node<T> right;
    public Node<T> up;
    public Node<T> down;
    public T       val;

    public Node[][] genNode(int n) {
        Node[][] res = new Node[n][n];
        doGenNode(null, n, res);
        return res;
    }

    public <T> Node<T> doGenNode(Node<T> root, int n, Node[][] res) {
        if (n <= 0) {
            return root;
        }

        res[n - 1][n - 1] = root;
        root.left = doGenNode(root, n - 1, res);
        root.right = doGenNode(root, n - 1, res);
        root.up = doGenNode(root, n - 1, res);
        root.down = doGenNode(root, n - 1, res);
        return root;
    }
    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        Node[][] res = node.genNode(3);
        System.out.println(res);
    }
}
