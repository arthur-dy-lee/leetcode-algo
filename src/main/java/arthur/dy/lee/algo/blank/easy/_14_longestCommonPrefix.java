package arthur.dy.lee.blank.easy;

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

        return strs[0];

    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println("strs1=" + _14_longestCommonPrefix.longestCommonPrefix(strs));
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("strs2=" + _14_longestCommonPrefix.longestCommonPrefix(strs2));

        String[] strs3 = { "a" };
        System.out.println("strs3=" + _14_longestCommonPrefix.longestCommonPrefix(strs3));
        String[] strs4 = { "abc", "a", "acd" };
        System.out.println("strs4=" + _14_longestCommonPrefix.longestCommonPrefix(strs4));

    }
}
