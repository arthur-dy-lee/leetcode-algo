package arthur.dy.lee.algo.blank.easy;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class _9_isPalindrome {

    public static boolean isPalindrome(int x) {

        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = -121;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 10;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 1221;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 1222;
        System.out.println(_9_isPalindrome.isPalindrome(x));
    }
}
