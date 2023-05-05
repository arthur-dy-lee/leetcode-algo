package arthur.dy.lee.answer.medium;

import cn.hutool.json.JSONUtil;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class _34_searchRange {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        } else if (nums.length == 1) {
            return nums[0] == target ? new int[] { 0, 0 } : new int[] { -1, -1 };
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return searchResult(nums, mid);
            }
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] { -1, -1 };

    }

    private static int[] searchResult(int[] nums, int start) {
        int left = start;
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--;
        }
        while (start <= nums.length - 2 && nums[start] == nums[start + 1]) {
            start++;
        }
        return new int[] { left, start };
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(JSONUtil.toJsonStr(_34_searchRange.searchRange(nums, target)));

        target = 6;
        System.out.println(JSONUtil.toJsonStr(_34_searchRange.searchRange(nums, target)));

        int[] nums2 = new int[] { 2, 2 };
        target = 2;
        System.out.println(JSONUtil.toJsonStr(_34_searchRange.searchRange(nums2, target)));
    }
}
