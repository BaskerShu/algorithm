package TwoPointers;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并到一个新的数组
        int [] nums = new int[m+n];
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            nums[i+j] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }
        while (i < m) {
            nums[i+j] = nums1[i++];
        }
        while (j < n) {
            nums[i+j] = nums2[j++];
        }
        return nums;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        merge2(nums1, 3, nums2, 3);
    }
}
