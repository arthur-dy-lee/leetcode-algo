package arthur.dy.lee.algo.classify.string;

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
public class _5_longestPalindrome_self {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String res = new String();
        for (int i = 0; i < s.length(); i++) {
            String tmp = isPalindrome(i, s);
            if (tmp.length() > res.length()) {
                res = tmp;
            }
        }
        return res;
    }

    private static String isPalindrome(int index, String s) {
        int end = index;
        int begin = index;

        while (end < s.length() - 1 && s.charAt(index) == s.charAt(end + 1)) {
            end++;
        }

        while (begin > 0 && end < s.length() - 1 && s.charAt(begin - 1) == s.charAt(end + 1)) {
            begin--;
            end++;
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        boolean res = "bab".equals(_5_longestPalindrome_self.longestPalindrome(s))
                || "aba".equals(_5_longestPalindrome_self.longestPalindrome(s));
        System.out.println(res);
        s = "cbbd";
        System.out.println("bb".equals(_5_longestPalindrome_self.longestPalindrome(s)));
        s = "bb";
        System.out.println("bb".equals(_5_longestPalindrome_self.longestPalindrome(s)));
    }
}
