package arthur.dy.lee.best.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 */
public class _22_generateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(result, n, new StringBuilder(), 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, int n, StringBuilder sb, int open, int close) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(result, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(")");
            backtrack(result, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {

        System.out.println(JSONUtil.toJsonStr(_22_generateParenthesis.generateParenthesis(3)));

        System.out.println(JSONUtil.toJsonStr(_22_generateParenthesis.generateParenthesis(1)));
    }

}
// +1