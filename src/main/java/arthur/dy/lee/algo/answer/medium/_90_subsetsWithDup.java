package arthur.dy.lee.algo.answer.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 90. 子集 II
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class _90_subsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums.length > 10) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, res, path, used, 0);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = Boolean.TRUE;
            dfs(nums, res, path, used, i);
            used[i] = Boolean.FALSE;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        //        int[] nums = new int[] { 1, 2, 2 };
        //        System.out.println(JSONUtil.toJsonStr(_80_subsetsWithDup.subsetsWithDup(nums)));
        int[] nums2 = new int[] { 1, 1 };
        System.out.println(JSONUtil.toJsonStr(_90_subsetsWithDup.subsetsWithDup(nums2)));
    }
}
