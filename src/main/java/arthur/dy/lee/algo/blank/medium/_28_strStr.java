package arthur.dy.lee.algo.blank.medium;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 中等
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 */
public class _28_strStr {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() <= 0 || haystack.length() > Math.pow(10, 4)
                || needle.length() <= 0 || needle.length() > Math.pow(10, 4)) {
            return -1;
        }

        char startChar = needle.charAt(0);
        for (int j = 0; j < haystack.length(); j++) {
            char h = haystack.charAt(j);
            if (startChar != h) {
                continue;
            }
            int i2 = 0;
            int j2 = j;

            while (i2 < needle.length() && j2 < haystack.length() && needle.charAt(i2) == haystack.charAt(j2)) {
                if (i2 == needle.length() - 1) {
                    return j;
                }
                i2++;
                j2++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(0 == _28_strStr.strStr(haystack, needle));

        haystack = "leetcode";
        needle = "leeto";
        System.out.println(-1 == _28_strStr.strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issip";
        System.out.println(4 == _28_strStr.strStr(haystack, needle));
    }
}
