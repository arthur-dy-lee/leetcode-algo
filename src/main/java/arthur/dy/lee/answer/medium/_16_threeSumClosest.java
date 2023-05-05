package arthur.dy.lee.answer.medium;

import java.util.Arrays;

public class _16_threeSumClosest {

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
                    left++;
                } else {
                    right--;
                }

            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(_16_threeSumClosest.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); //2
        System.out.println(_16_threeSumClosest.threeSumClosest(new int[] { 0, 0, 0 }, 0));  //0
        System.out.println(_16_threeSumClosest.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));  //2
        System.out.println(_16_threeSumClosest.threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2)); //-2

    }
}