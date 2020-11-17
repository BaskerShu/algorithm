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

    // 堆排
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, --heapSize);
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        var obj = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};

        System.out.println(obj.findKthLargest2(nums, 2));
    }
}
