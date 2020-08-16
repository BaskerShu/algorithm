package BinarySearch;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[l]) {
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else if (target <= nums[r]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var obj = new SearchInRotatedSortedArray();
        int[] nums = {3, 1};

        int ans = obj.search(nums, 1);
        System.out.println(ans);
    }
}
