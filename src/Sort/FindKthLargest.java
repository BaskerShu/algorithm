package Sort;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    // 快排
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        return partition(nums, 0, nums.length-1, k-1);
    }

    public int partition(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int i = l;
        int j = l;

        for (; j < r; j++) {
            if (nums[j] > pivot) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        nums[r] = nums[i];
        nums[i] = pivot;

        if (i == k) {
            return pivot;
        } else if (i < k) {
            return partition(nums, i+1, r, k);
        } else {
            return partition(nums, l, i-1, k);
        }
    }
}
