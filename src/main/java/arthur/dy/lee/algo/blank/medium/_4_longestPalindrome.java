package arthur.dy.lee.algo.blank.medium;

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

    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        String result = new String();

        return result;
    }


    public static void main(String[] args) {
        String s = "babad";
        System.out.println("result=" + _4_longestPalindrome.longestPalindrome1(s));
        System.out.println(_4_longestPalindrome.longestPalindrome1(s).equals("bab")
                || _4_longestPalindrome.longestPalindrome1(s).equals("aba"));
        s = "cbbd";
        System.out.println("bb".equals(_4_longestPalindrome.longestPalindrome1(s)));
        s = "a";
        System.out.println("a".equals(_4_longestPalindrome.longestPalindrome1(s)));
        s = "ccc";
        System.out.println("ccc".equals(_4_longestPalindrome.longestPalindrome1(s)));

        System.out.println("---");
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(0, 0));
    }
}
