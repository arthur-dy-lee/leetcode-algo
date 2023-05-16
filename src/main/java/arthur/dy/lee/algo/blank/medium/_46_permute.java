package arthur.dy.lee.blank.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。你可以按任意顺序返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * https://leetcode.cn/problems/permutations/solutions/9914/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class _46_permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, path, used, 0);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used, int depth) {

        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.push(nums[i]);
            used[i] = Boolean.TRUE;
            dfs(nums, res, path, used, depth + 1);
            System.out.println(JSONUtil.toJsonStr(path));
            path.pop();
            used[i] = Boolean.FALSE;
        }
    }

    public static void main(String[] args) {

        int[] nums2 = new int[] { 1, 2, 3 };
        System.out.println(_46_permute.permute(nums2));
        System.out.println("------------------------\n");
        int[] nums1 = new int[] { 0, 1 };
        System.out.println(_46_permute.permute(nums1));

    }
}
