package arthur.dy.lee.algo.answer.medium;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class _15_threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (val > 0) {
                break;  // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = val + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(val, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // 去重
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // 去重
                    }
                    left++;
                    right--;

                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 })));
        System.out.println(JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { 0, 0, 0, 0 })));
        System.out.println(JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { 1, 0, -1 })));
        System.out.println(JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 })));
        System.out.println(JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { 0, 1, 1 })));
        System.out.println(JSONUtil.toJsonStr(_15_threeSum.threeSum(new int[] { 0, 0, 0 })));

    }
}
