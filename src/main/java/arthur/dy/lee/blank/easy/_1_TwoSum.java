package arthur.dy.lee.blank.easy;

import cn.hutool.json.JSONUtil;

/**
 * @TODO
 */
public class _1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        throw new IllegalArgumentException("not exist in nums");
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        System.out.println(JSONUtil.toJsonStr(twoSum(nums, 6)));
        int[] nums2 = { 2, 7, 11, 15 };
        System.out.println(JSONUtil.toJsonStr(twoSum(nums2, 9)));
    }
}
