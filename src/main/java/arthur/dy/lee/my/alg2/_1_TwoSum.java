package arthur.dy.lee.my.alg2;


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
