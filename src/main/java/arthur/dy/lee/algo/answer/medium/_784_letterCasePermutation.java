package arthur.dy.lee.algo.answer.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 中等
 * 533
 * 相关企业
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * 示例 1：
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 示例 2:
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * 提示:
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */
public class _784_letterCasePermutation {
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        //char[] charArray = S.toCharArray();
        dfs(s, res, "", 0);
        return res;
    }

    public static void dfs(String s, List<String> res, String path, int i) {
        if (i == s.length()) {
            res.add(path.toString());
            return;
        }

        char tmp = s.charAt(i);
        while (i < s.length() - 1 && tmp - '0' >= 0 && tmp - '0' <= 9) {
            path = path + tmp;
            i++;
            tmp = s.charAt(i);
        }
        if (i == s.length() - 1 && tmp - '0' >= 0 && tmp - '0' <= 9) {
            res.add(path + tmp);
            return;
        }
        dfs(s, res, path + Character.toLowerCase(tmp), i + 1);
        dfs(s, res, path + Character.toUpperCase(tmp), i + 1);

    }

    /**
     * 大写字符与其对应的小写字符的 ASCII 的差为 32，32 这个值如果敏感的话，它是 2^5=32，
     * 在编程语言中，可以表示为 1 << 5。而变换大小写这件事等价于：
     * 如果字符是小写字符，减去 32 得到大写字符；
     * 如果字符是大写字符，加上 32 得到小写字符。
     * 而这两者合并起来，就是给这个字符做一次不进位的加法，即异或上 1 << 5。
     */
    private void dfs2(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs2(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs2(charArray, index + 1, res);
        }
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(JSONUtil.toJsonStr(_784_letterCasePermutation.letterCasePermutation(s)));

        String s2 = "C";
        System.out.println(JSONUtil.toJsonStr(_784_letterCasePermutation.letterCasePermutation(s2)));

        char a = 'a';
        char b = (char) (a ^ (1 << 5));
        char c = 'A';
        char d = (char) (c ^ (1 << 5));
        System.out.println(" b=" + b + ", d=" + d);
    }
}
