package arthur.dy.lee.blank.medium;

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
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        self_dfs(res, n, sb, 0, 0);
        return res;
    }

    private static void self_dfs(List<String> res, int n, StringBuilder sb, int left, int right) {

        if (left == n && right == n) {
            res.add(new String(sb.toString()));
            return;
        }
        if (right > left) {
            return;
        }
        if (left < n) {
            sb.append("(");
            self_dfs(res, n, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            self_dfs(res, n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs2(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs2(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs2(curStr + ")", left, right + 1, n, res);
        }
    }

    private static void backtrack3(List<String> result, int n, StringBuilder sb, int open, int close) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack3(result, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(")");
            backtrack3(result, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public static void main(String[] args) {

        System.out.println(JSONUtil.toJsonStr(_22_generateParenthesis.generateParenthesis(3)));

        //        System.out.println(JSONUtil.toJsonStr(_22_generateParenthesis.generateParenthesis(1)));
    }

}
// +1