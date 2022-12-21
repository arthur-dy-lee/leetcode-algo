package arthur.dy.lee.blank.medium;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 使用堆排序来解决这个问题——建立一个大根堆，做 k−1k - 1k−1 次删除操作后堆顶元素就是我们要找的答案。在很多语言中，
 * 都有优先队列或者堆的的容器可以直接使用，但是在面试中，面试官更倾向于让更面试者自己实现一个堆。所以建议读者掌握这里大根堆的实现方法，
 * 在这道题中尤其要搞懂「建堆」、「调整」和「删除」的过程。
 */
public class _215_findKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums2 = new int[] { 3, 2, 1, 5, 6, 4 };
        int target2 = 2;
        System.out.println(5 == _215_findKthLargest.findKthLargest(nums2, target2));

        int[] nums1 = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int target1 = 4;
        System.out.println(4 == _215_findKthLargest.findKthLargest(nums1, target1));
    }
}
