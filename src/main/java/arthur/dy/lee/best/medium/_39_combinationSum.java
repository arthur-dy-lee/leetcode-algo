package arthur.dy.lee.best.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
 * ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 * https://leetcode.cn/problems/combination-sum/solutions/14697/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 */
public class _39_combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path,
                            List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            int cand = candidates[i];
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = new int[] { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(_39_combinationSum.combinationSum(candidates1, target));

        //        int[] candidates2 = new int[] { 2, 3, 5 };
        //        target = 8;
        //        System.out.println(_39_combinationSum.combinationSum(candidates2, target));
        //
        //        int[] candidates3 = new int[] { 2 };
        //        target = 1;
        //        System.out.println(_39_combinationSum.combinationSum(candidates3, target));

        //        List<List<Integer>> ans = new ArrayList<>();
        //        List<List<Integer>> ans2 = new ArrayList<>();
        //        List<Integer> combine = Arrays.asList(1, 2, 3);
        //        List<Integer> combine2 = Arrays.asList(4, 5, 3);
        //        ans.add(new ArrayList<>(combine));
        //        ans.add(new ArrayList<>(combine2));
        //        ans2.add(combine);
        //        ans2.add(combine2);
        //        System.out.println(JSONUtil.toJsonStr(ans));
        //        System.out.println(JSONUtil.toJsonStr(ans2));
    }
}
