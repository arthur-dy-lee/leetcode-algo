package arthur.dy.lee.algo.answer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class _3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(3 == arthur.dy.lee.algo.blank.medium._3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(1 == arthur.dy.lee.algo.blank.medium._3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(3 == arthur.dy.lee.algo.blank.medium._3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(2 == arthur.dy.lee.algo.blank.medium._3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(1 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "dvdf";
        System.out.println(3 == _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

}
