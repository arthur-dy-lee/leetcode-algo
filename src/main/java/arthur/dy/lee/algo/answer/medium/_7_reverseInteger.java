package arthur.dy.lee.algo.answer.medium;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
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
 * -231 <= x <= 231 - 1
 */
public class _7_reverseInteger {
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        int x1 = 123;
        _7_reverseInteger.reverse(x1);
        int x2 = -123;
        _7_reverseInteger.reverse(x2);
        int x3 = 0;
        _7_reverseInteger.reverse(x3);
        x1 = 1534236469;
        _7_reverseInteger.reverse(x1);
    }
}
