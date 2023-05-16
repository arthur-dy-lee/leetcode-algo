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
public class _5_longestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String res = new String();

        return res;
    }


    public static void main(String[] args) {
        String s = "babad";
        boolean res = "bab".equals(_5_longestPalindrome.longestPalindrome(s))
                || "aba".equals(_5_longestPalindrome.longestPalindrome(s));
        System.out.println(res);
        s = "cbbd";
        System.out.println("bb".equals(_5_longestPalindrome.longestPalindrome(s)));
        s = "bb";
        System.out.println("bb".equals(_5_longestPalindrome.longestPalindrome(s)));
    }
}
