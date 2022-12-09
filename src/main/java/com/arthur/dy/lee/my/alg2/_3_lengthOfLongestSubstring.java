package com.arthur.dy.lee.my.alg2;

import java.util.HashMap;
import java.util.Map;

public class _3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        byte[] str = s.getBytes();
        Map<Byte, Integer> map = new HashMap();
        int longest = 0;
        int k = 0;
        int i = 0;
        while (k < s.length() && i < s.length()) {
            if (map.get(str[i]) == null) {
                map.put(str[i], i);
            } else {
                k = map.get(str[i]) + 1;
                i = map.get(str[i]);
                if (longest < map.size()) {
                    longest = map.size();
                }
                map = new HashMap();
            }
            i++;
        }
        if (longest < map.size()) {
            longest = map.size();
        }
        System.out.println(longest);
        return longest;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s);

        s = "bbbbb";
        _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s);

        s = "pwwkew";
        _3_lengthOfLongestSubstring.lengthOfLongestSubstring(s);
    }

}
