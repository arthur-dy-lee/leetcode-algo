package arthur.dy.lee.blank.medium;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class _3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(3 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(1 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(3 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(2 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(1 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "dvdf";
        System.out.println(3 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

}
