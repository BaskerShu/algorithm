package DivideAndConquer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 912. 排序数组
 */
public class SortArray {

    // 冒泡排序
    public int[] sortArray(int[] nums) {
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            boolean flag = false;

            for (int j = 1; j < numsLen-i; j++) {
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    flag = true;
                }
            }

            if (!flag) break;
        }

        return nums;
    }

    // 插入排序
    public int[] sortArray2(int[] nums) {
        int numsLen = nums.length;

        for (int i = 1; i < numsLen; i++) {
            int num = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > num) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }

            nums[j+1] = num;
        }

        return nums;
    }

    // 选择排序
    public int[] sortArray3(int[] nums) {
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            int min = i;

            for (int j = i+1; j < numsLen; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

    // 归并
    public int[] sortArray4(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    public void merge(int[] nums, int l, int r) {
        if (r <= l) return;

        int mid = l + (r - l) / 2;
        merge(nums, l, mid);
        merge(nums, mid+1, r);

        int[] temp = new int[r-l+1];
        int p = l;
        int q = mid + 1;
        for (int i = l; i <= r; i++) {
            if (p <= mid && q <= r) {
                temp[i-l] = nums[p] <= nums[q] ? nums[p++] : nums[q++];
            } else if (p > mid) {
                temp[i-l] = nums[q++];
            } else {
                temp[i-l] = nums[p++];
            }
        }

        System.arraycopy(temp, 0, nums, l, r + 1 - l);
    }

    // 快排
    public int[] sortArray5(int[] nums) {
        partition(nums, 0, nums.length - 1);

        return nums;
    }

    public void partition(int[] nums, int l, int r) {
        if (l > r) return;

        int pivot = nums[r];
        int i = l, j = l;
        for (; j < r; j++) {
            if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        nums[r] = nums[i];
        nums[i] = pivot;

        partition(nums, l, i-1);
        partition(nums, i+1, r);
    }

    public static void main(String[] args) {
        var obj = new SortArray();
        int[] nums = {5, 2, 3, 1};

        int[] ans = obj.sortArray5(nums);
        System.out.println(Arrays.toString(ans));
    }

}
