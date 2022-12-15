package arthur.dy.lee.my.alg2;

public class _33_searchRotate {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        } else if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return left != right ? -1 : left;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        System.out.println(_33_searchRotate.search(nums1, target1));

        int target2 = 3;
        System.out.println(_33_searchRotate.search(nums1, target2));

        int[] nums3 = new int[] { 1 };
        int target3 = 0;
        System.out.println(_33_searchRotate.search(nums3, target3));
    }
}
