package arthur.dy.lee.algo.answer.medium;

import cn.hutool.json.JSONUtil;

/**
 * 31. 下一个排列
 * <p>
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class _31_nextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0);
            return;
        }
        int j = len - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swop(nums, i, j);
        reverse(nums, i + 1);
    }

    private static void swop(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            swop(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 2, 6, 3, 1 };
        _31_nextPermutation.nextPermutation(nums);
        System.out.println(JSONUtil.toJsonStr(nums));

        int[] nums1 = new int[] { 1, 2, 3 };
        _31_nextPermutation.nextPermutation(nums1);
        System.out.println(JSONUtil.toJsonStr(nums1));

        int[] nums2 = new int[] { 3, 2, 1 };
        _31_nextPermutation.nextPermutation(nums2);
        System.out.println(JSONUtil.toJsonStr(nums2));

        int[] nums3 = new int[] { 1, 1, 5 };
        _31_nextPermutation.nextPermutation(nums3);
        System.out.println(JSONUtil.toJsonStr(nums3));

        int[] nums4 = new int[] { 1, 5, 1 };
        _31_nextPermutation.nextPermutation(nums4);
        System.out.println(JSONUtil.toJsonStr(nums4));

        int[] nums5 = new int[] { 1, 1 };
        _31_nextPermutation.nextPermutation(nums5);
        System.out.println(JSONUtil.toJsonStr(nums5));

        int[] nums6 = new int[] { 5, 1, 1 };
        _31_nextPermutation.nextPermutation(nums6);
        System.out.println(JSONUtil.toJsonStr(nums6));
    }
}
//+1