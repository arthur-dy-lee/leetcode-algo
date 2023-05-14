package arthur.dy.lee.blank.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 输入：digits = ""
 * 输出：[]
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
 */
public class _17_letterCombinations {

    private static final String[] val = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(digits, res, path, 0);
        return res;
    }

    public static void dfs(String digits, List<String> res, StringBuilder path, int depth) {
        if (digits.length() == depth) {
            res.add(path.toString());
            return;
        }

        String tmp = val[digits.charAt(depth) - '0'];
        for (int i = 0; i < tmp.length(); i++) {
            path.append(tmp.charAt(i));
            dfs(digits, res, path, depth + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {

        String digits = "234";
        System.out.println(_17_letterCombinations.letterCombinations(digits));
        //        digits = "2";
        //        System.out.println(_17_letterCombinations.letterCombinations(digits));

    }
}
//+1