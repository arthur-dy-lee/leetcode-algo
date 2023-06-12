package arthur.dy.lee.algo.test;

public class N4 {

    public N4  parent;
    public N4  left;
    public N4  right;
    public int val;

    public static N4 build(int n) {
        return doBuild(null, n);
    }

    public static N4 doBuild(N4 parent, int n) {
        if (n <= 0) {
            return null;
        }

        N4 nd = new N4();
        nd.parent = parent;
        nd.val = n;
        nd.left = doBuild(parent, n - 1);
        nd.right = doBuild(parent, n - 1);
        return nd;
    }

    @Override public String toString() {
        StringBuilder res = new StringBuilder();
        preN(this, res);
        return res.toString();
    }

    public void preN(N4 nd, StringBuilder res) {
        if (nd == null) {
            return;
        }
        res.append(nd.val);
        preN(nd.left, res);
        preN(nd.left, res);
    }

    public static void main(String[] args) {
        N4 root = new N4();
        int n = 3;
        N4 newTest3 = root.build(n);
        System.out.println(newTest3.toString());
    }
}
