package arthur.dy.lee.algo.test;

public class Test2 {
    public Test2 parent;
    public Test2 left;
    public Test2 right;
    public int   val;

    public static Test2 build(int n) {
        return _build(null, n);
    }

    private static Test2 _build(Test2 parent, int n) {
        if (n <= 0) {
            return null;
        }
        Test2 test2 = new Test2();
        test2.val = n;
        test2.parent = parent;
        test2.left = _build(test2, n - 1);
        test2.right = _build(test2, n - 1);
        return test2;
    }

    @Override public String toString() {
        StringBuilder res = new StringBuilder();
        preNode(this, res);
        return res.toString();
    }

    public void preNode(Test2 root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res.append(root.val);
        preNode(root.left, res);
        preNode(root.right, res);
    }

    public static void main(String[] args) {
        Test2 root = new Test2();
        int n=4;
        Test2 newTest2 = root.build(n);
        System.out.println(newTest2.toString());
    }
}
