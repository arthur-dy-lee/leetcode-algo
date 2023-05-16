package arthur.dy.lee.algo.classify.greedy;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 */
public class _45_jump {

    public static int jump(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                // 能跳到最远的距离
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;      // 下一次起跳点范围开始的格子
            end = maxPos + 1; // 下一次起跳点范围结束的格子
            ans++;            // 跳跃次数
        }
        return ans;

    }

    /**
     * 优化
     * <p>
     * 从上面代码观察发现，其实被 while 包含的 for 循环中，i 是从头跑到尾的。
     * 只需要在一次 跳跃 完成时，更新下一次 能跳到最远的距离。
     * 并以此刻作为时机来更新 跳跃 次数。
     * 就可以在一次 for 循环中处理。
     */
    public static int jump2_opt(int[] nums) {
        if (nums == null || nums.length < 1 || nums.length > Math.pow(10, 4)) {
            return 0;
        }
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            int tmp = i + nums[i];
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static int jump3(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums9 = new int[] { 4, 1, 1, 3, 1, 1, 1 };
        System.out.println(2 == _45_jump.jump(nums9));  //2

        int[] nums8 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
        System.out.println(2 == _45_jump.jump(nums8));  //2

        int[] nums7 = new int[] { 1, 2, 1, 1, 1 };
        System.out.println(3 == _45_jump.jump(nums7));  //3

        int[] nums6 = new int[] { 2, 3, 1, 1, 4 };
        System.out.println(2 == _45_jump.jump(nums6));  //2

        int[] nums5 = new int[] { 2, 1 };
        System.out.println(1 == _45_jump.jump(nums5));  //1

        int[] nums4 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(3 == _45_jump.jump(nums4));  //3

        int[] nums3 = new int[] { 1, 2, 0, 1 };
        System.out.println(2 == _45_jump.jump(nums3));  //2

        int[] nums2 = new int[] { 2, 3, 0, 1, 4 };
        System.out.println(2 == _45_jump.jump(nums2));  //2

        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        System.out.println(2 == _45_jump.jump(nums));  //2

    }
}
