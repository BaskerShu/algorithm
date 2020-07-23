package DivideAndConquer;

import javax.swing.plaf.basic.BasicSplitPaneUI;

// 153. 寻找旋转排序数组中的最小值
public class FindMin153 {

    // 分治
    public int findMin(int[] nums) {
        if (nums == null) return -1;

        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (nums[end] >= nums[start]) return nums[start];

        int mid = start + (end - start) / 2;
        int minL = findMin(nums, start, mid);
        int minR = findMin(nums, mid+1, end);
        return Math.min(minL, minR);
    }

    // 二分查找
    public int findMin2(int[] nums) {
        if (nums == null) return -1;

        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // 二分查找 - 优化
    public int findMin3(int[] nums) {
        if (nums == null) return -1;

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
