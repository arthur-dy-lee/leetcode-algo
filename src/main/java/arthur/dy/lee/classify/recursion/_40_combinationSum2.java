package arthur.dy.lee.classify.recursion;

import cn.hutool.json.JSONUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * https://leetcode.cn/problems/combination-sum-ii/solutions/14753/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class _40_combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> combine = new ArrayDeque<>();
        Arrays.sort(candidates);
        recursive(candidates, target, res, combine, 0);
        return res;
    }

    private static void recursive(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> combine,
                                  int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = begin; i < candidates.length - 1; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combine.addLast(candidates[i]);
            recursive(candidates, target - candidates[i], res, combine, i + 1);
            combine.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(JSONUtil.toJsonStr(_40_combinationSum2.combinationSum2(candidates, target)));

        int[] candidates2 = new int[] { 2, 5, 2, 1, 2 };
        int target2 = 5;
        System.out.println(JSONUtil.toJsonStr(_40_combinationSum2.combinationSum2(candidates2, target2)));
    }
}


