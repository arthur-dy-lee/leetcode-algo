package arthur.dy.lee.algo.answer.easy;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
public class _35_searchInsert {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums3 = new int[] { 1, 2, 4, 6, 7 };
        int target3 = 3;
        System.out.println(_35_searchInsert.searchInsert(nums3, target3));  //2

        int[] nums2 = new int[] { 1 };
        int target2 = 0;
        System.out.println(_35_searchInsert.searchInsert(nums2, target2));  //0

        int[] nums1 = new int[] { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(_35_searchInsert.searchInsert(nums1, target));  //2

        target = 2;
        System.out.println(_35_searchInsert.searchInsert(nums1, target));  //1

        target = 7;
        System.out.println(_35_searchInsert.searchInsert(nums1, target));  //4
    }
}
