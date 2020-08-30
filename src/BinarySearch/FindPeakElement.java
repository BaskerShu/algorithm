package BinarySearch;

/**
 * 162. 寻找峰值
 */
public class FindPeakElement {

    // 二分查找
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (r == l) return l;
            if ((mid + 1 >= nums.length || nums[mid] > nums[mid + 1]) && (mid - 1 < 0 || nums[mid] > nums[mid - 1])){
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]){
                l = mid + 1;
            } else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]){
                r = mid - 1;
            }
        }

        return -1;
    }

    // 二分查找（优化版）
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;
        if (l < r) {  // 这里用 l < r,就可以避免mid+1 的判断
            int mid = r + (l - r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        var obj = new FindPeakElement();
        int[] nums = {2, 1, 2};
        int ans = obj.findPeakElement(nums);

        System.out.println(ans);
    }
}
