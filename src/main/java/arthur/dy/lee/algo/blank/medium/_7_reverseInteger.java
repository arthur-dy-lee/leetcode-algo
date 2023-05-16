package arthur.dy.lee.algo.blank.medium;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 2^31 - 1
 */
public class _7_reverseInteger {
    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            res = res * 10 + tmp;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int x1 = 123;
        System.out.println(321 == _7_reverseInteger.reverse(x1));
        int x2 = -123;
        System.out.println(-321 == _7_reverseInteger.reverse(x2));
        int x3 = 0;
        System.out.println(0 == _7_reverseInteger.reverse(x3));
        int x4 = 120;
        System.out.println(21 == _7_reverseInteger.reverse(x4));
        int x5 = 1534236469;
        System.out.println(0 == _7_reverseInteger.reverse(x5));
        int x6 = -2147483412;
        System.out.println(0 == _7_reverseInteger.reverse(x6));
    }
}
