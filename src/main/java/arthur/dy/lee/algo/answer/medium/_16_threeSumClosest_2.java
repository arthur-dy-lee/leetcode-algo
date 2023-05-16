package arthur.dy.lee.algo.answer.medium;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
 *
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class _16_threeSumClosest_2 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (target == sum) {
                    return sum;
                } else if (Math.abs(target - sum) < Math.abs(target - ret)) {
                    ret = sum;
                }
                if (target - sum > 0) {
                    // 解决nums[left]重复
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    left++;
                } else {
                    right--;
                    // 解决nums[right]重复
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            // 解决nums[i]重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); //2
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 0, 0, 0 }, 0));  //0
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));  //2
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2)); //-2

    }
}