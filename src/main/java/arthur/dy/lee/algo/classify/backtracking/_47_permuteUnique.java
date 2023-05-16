package arthur.dy.lee.classify.backtracking;

import arthur.dy.lee.blank.medium._46_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class _47_permuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums, res, path, 0, used);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path, int depth, boolean[] used) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = Boolean.TRUE;
            dfs(nums, res, path, depth + 1, used);
//            System.out.println(JSONUtil.toJsonStr(path));
            path.removeLast();
            used[i] = Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        int[] nums2 = new int[] { 1, 1, 2 };
        System.out.println(_47_permuteUnique.permuteUnique(nums2));
        System.out.println("------------------------\n");
        int[] nums1 = new int[] { 1, 2, 3 };
        System.out.println(_46_permute.permute(nums1));
        System.out.println("------------------------\n");
        int[] nums3 = new int[] { 3, 3, 0, 3 };
        System.out.println(_47_permuteUnique.permuteUnique(nums3));
    }
}
