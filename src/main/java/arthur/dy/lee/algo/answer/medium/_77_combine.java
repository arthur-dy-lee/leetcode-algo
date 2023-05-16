package arthur.dy.lee.algo.answer.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 相关企业
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class _77_combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || k > n || n < 1 || n > 20) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, n, k, 0, n);
        return res;
    }

    public static void dfs(List<List<Integer>> res, Deque<Integer> path, int n, int k, int depth, int begin) {

        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i >= 1; i--) {
            path.push(i);
            dfs(res, path, n, k, depth + 1, i - 1);
            path.pop();
        }
    }

    private void dfs2(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs2(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(_77_combine.combine(4, 2)));
    }
}
