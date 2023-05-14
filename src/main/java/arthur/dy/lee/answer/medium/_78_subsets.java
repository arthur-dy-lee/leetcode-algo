package arthur.dy.lee.answer.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class _78_subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, res, path, 0);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.push(nums[i]);
            dfs(nums, res, path, i + 1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        System.out.println(JSONUtil.toJsonStr(_78_subsets.subsets(nums)));

    }
}