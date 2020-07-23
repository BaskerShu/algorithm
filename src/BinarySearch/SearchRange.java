package BinarySearch;

import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null) return ans;

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid+1]) {
                    ans[1] = mid;
                    break;
                }
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid-1]) {
                    ans[0] = mid;
                    break;
                }
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};

        int begin = search(nums, target);
        int end = search(nums, target+1);
        if (begin >= nums.length || nums[begin] != target) {
            return ans;
        }
        ans[0] = begin;
        ans[1] = end;
        return ans;
    }

    // 寻找nums中第一个>=t的位置
    public static int search(int[] nums, int target) {
        if (nums == null) return -1;

        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        var ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
