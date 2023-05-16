package arthur.dy.lee.algo.answer.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _20_isValidBracket {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return Boolean.FALSE;
        }
        int len = s.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
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
