package arthur.dy.lee.answer.medium;

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
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
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
