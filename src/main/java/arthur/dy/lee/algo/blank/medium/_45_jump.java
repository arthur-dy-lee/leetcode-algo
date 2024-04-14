package arthur.dy.lee.algo.blank.medium;

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
        if (nums == null || nums.length < 1 || nums.length > Math.pow(10, 4)) {
            return 0;
        }
        int count = 0;
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            int t1 = nums[i];
            if (t1 - i > 0) {
                int t2 = Math.max(nums[t1], nums[t1 - i]);
                if (t2 > maxStep) {
                    maxStep = t2;
                    count++;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        //        int[] nums8 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
        //        System.out.println(2 == _45_jump.jump(nums8));  //10
        //
        //        int[] nums7 = new int[] { 1, 2, 1, 1, 1 };
        //        System.out.println(3 == _45_jump.jump(nums7));

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
