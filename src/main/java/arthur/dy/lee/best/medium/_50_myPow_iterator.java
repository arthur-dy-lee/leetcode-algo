package arthur.dy.lee.best.medium;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2 ^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * -104 <= xn <= 104
 */
public class _50_myPow_iterator {
    public static double myPow(double x, int n) {
        return n > 0 ? compute(x, n) : 1 / compute(x, -n);
    }

    private static double compute(double x, int n) {
        if (n == 0) {
            return 1L;
        }
        double y = compute(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(_50_myPow_iterator.myPow(2, 2));
        System.out.println(_50_myPow_iterator.myPow(2, 3));
    }
}
