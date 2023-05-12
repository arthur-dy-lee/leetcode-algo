package arthur.dy.lee.blank.medium;

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
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); //2
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 0, 0, 0 }, 0));  //0
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));  //2
        System.out.println(_16_threeSumClosest_2.threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2)); //-2

    }
}