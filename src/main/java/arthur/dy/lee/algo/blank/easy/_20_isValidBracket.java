package arthur.dy.lee.blank.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _20_isValidBracket {

    private static final Map<Character, Character> map = new HashMap() {
        {
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }
    };

    public static boolean isValid(String s) {

        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(_20_isValidBracket.isValid(s));
        s = "()[]{}";
        System.out.println(_20_isValidBracket.isValid(s));
        s = "(]";
        System.out.println(_20_isValidBracket.isValid(s));
        s = "(())[]";
        System.out.println(_20_isValidBracket.isValid(s));
        s = "(({}))[]";
        System.out.println(_20_isValidBracket.isValid(s));
    }
}
