package arthur.dy.lee.algo.test;

public class Test3 {
    public Test3 parent;
    public Test3 left;
    public Test3 right;
    public int   val;

    public static Test3 build(int n) {

        return doBuild(null, n);
    }

    public static Test3 doBuild(Test3 parent, int n) {
        if (n <= 0) {
            return null;
        }
        Test3 test3 = new Test3();
        test3.parent = parent;
        test3.val = n;
        test3.left = doBuild(test3, n - 1);
        test3.right = doBuild(test3, n - 1);

        return test3;
    }
    @Override public String toString() {
        StringBuilder res = new StringBuilder();
        preNode(this, res);
        return res.toString();
    }

    public void preNode(Test3 root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res.append(root.val);
        preNode(root.left, res);
        preNode(root.right, res);
    }
    public static void main(String[] args) {
        Test3 root = new Test3();
        int n = 3;
        Test3 newTest3 = root.build(n);
        System.out.println(newTest3.toString());
    }
}
