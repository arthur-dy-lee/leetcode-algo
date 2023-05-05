package arthur.dy.lee.answer.medium;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class _11_maxArea {

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int leftVal = height[leftIndex];
            int rightVal = height[rightIndex];
            max = Math.max(max, (rightIndex - leftIndex) * Math.min(leftVal, rightVal));
            if (leftVal > rightVal) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(_11_maxArea.maxArea(height));
    }

}
