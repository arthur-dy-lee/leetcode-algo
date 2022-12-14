package arthur.dy.lee.best;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class _4_longestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = maxLen(s, i, i);
            int len2 = maxLen(s, i, i + 1);
            int len = len2 > len1 ? len2 : len1;
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        String ret = s.substring(start, end + 1);
        System.out.println(ret);
        return ret;
    }

    private static int maxLen(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        _4_longestPalindrome.longestPalindrome(s);
        s = "cbbd";
        _4_longestPalindrome.longestPalindrome(s);

        System.out.println(1/2);
    }
}
