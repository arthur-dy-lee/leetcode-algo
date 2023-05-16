package arthur.dy.lee.answer.easy;


/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @TODO
 */
public class _1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) {
            throw new IllegalArgumentException("not exist in nums");
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }

        }
        throw new IllegalArgumentException("not exist in nums");
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        System.out.println(JSONUtil.toJsonStr(twoSum(nums, 6)));
        int[] nums2 = { 2, 7, 11, 15 };
        System.out.println(JSONUtil.toJsonStr(twoSum(nums2, 9)));
    }
}
