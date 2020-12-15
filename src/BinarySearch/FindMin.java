package BinarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (h - l == 1) {
                return Math.min(nums[l], nums[0]);
            } else if (nums[mid] > nums[l] && nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    public int findMin2(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        var obj = new FindMin();
        int ans = obj.findMin(nums);

        System.out.println(ans);
    }
}
