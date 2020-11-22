package Sort;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColor {
    // 双指针
    public void sortColor(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        int i = 0, p0 = 0, p1 = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1++);
            } else if (nums[i] == 2) {

            }
        }
    }

    // 单指针
    public void sortColor2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, cur++);
            }
        }

        for (int i = cur; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, cur++);
            }
        }
    }

    // 双指针2
    public void sortColor3(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int p0 = 0; int p2 = nums.length - 1;
        for (int i = 0; i < p2; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0++);
            } else if (nums[i] == 2) {
                while (i < p2 && nums[i] == 2) {
                    swap(nums, i, p2--);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        var obj = new SortColor();

        int[] nums = new int[]{2, 0, 1, 1, 2, 0};
        obj.sortColor(nums);

        System.out.println(Arrays.toString(nums));
    }
}
