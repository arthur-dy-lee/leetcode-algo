package arthur.dy.lee.algo.answer.easy;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class _14_longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(_14_longestCommonPrefix.longestCommonPrefix(strs));
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println(_14_longestCommonPrefix.longestCommonPrefix(strs2));

        String[] strs3 = { "a" };
        System.out.println(_14_longestCommonPrefix.longestCommonPrefix(strs3));
        String[] strs4 = { "abc", "a", "acd" };
        System.out.println(_14_longestCommonPrefix.longestCommonPrefix(strs4));

    }
}
