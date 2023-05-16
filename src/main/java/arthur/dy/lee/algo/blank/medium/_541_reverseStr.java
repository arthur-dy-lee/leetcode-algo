package arthur.dy.lee.algo.blank.medium;

/**
 * 541. 反转字符串 II
 * 简单
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class _541_reverseStr {
    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();

        return new String(arr);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println("bacdfeg".equals(_541_reverseStr.reverseStr(s, k)));

        System.out.println("0%2=" + (0 % 2) + ", 1 % 2=" +
                1 % 2 + "," + " 2%2=" + (2 % 2) + ",3%2=" + (3 % 2) + ", 4%2=" + (4 % 2) + ", 5%2=" + (5 % 2));
    }
}
