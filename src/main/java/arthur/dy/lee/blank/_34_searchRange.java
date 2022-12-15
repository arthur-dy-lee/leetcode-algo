package arthur.dy.lee.blank;

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

        return new int[] { -1, -1 };

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(JSONUtil.toJsonStr(arthur.dy.lee.best._34_searchRange.searchRange(nums, target)));

        target = 6;
        System.out.println(JSONUtil.toJsonStr(arthur.dy.lee.best._34_searchRange.searchRange(nums, target)));

        int[] nums2 = new int[] { 2, 2 };
        target = 2;
        System.out.println(JSONUtil.toJsonStr(arthur.dy.lee.best._34_searchRange.searchRange(nums2, target)));
    }
}
