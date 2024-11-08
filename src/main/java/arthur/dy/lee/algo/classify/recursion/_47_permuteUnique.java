package arthur.dy.lee.algo.classify.recursion;

import java.util.ArrayList;
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
 * <p>
 * https://leetcode.cn/problems/permutations-ii/solutions/9917/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class _47_permuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        dfs(nums, res, new LinkedList<>(), new boolean[nums.length], 0);
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
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            System.out.println("  递归之前 => " + path);
            dfs(nums, res, path, used, depth + 1);
            used[i] = false;
            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }

    public static void main(String[] args) {
        int[] nums2 = new int[] { 1, 1, 2 };
        System.out.println(_47_permuteUnique.permuteUnique(nums2));
        System.out.println("------------------------\n");
        int[] nums1 = new int[] { 1, 2, 3 };
        System.out.println(_47_permuteUnique.permuteUnique(nums1));
    }
}
