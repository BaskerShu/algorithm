package DivideAndConquer;

// 154. 寻找旋转排序数组中的最小值 II
// 和153相比可能会存在重复数组
public class FindMin154 {

    // 分治
    public int findMin(int[] nums) {
        if (nums == null) return -1;

        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end || nums[start] < nums[end]) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        int minL = findMin(nums, start, mid);
        int minR = findMin(nums, mid+1, end);

        return Math.min(minL, minR);
    }

    // 二分查找
    public int findMin2(int[] nums) {
        if (nums == null) return -1;

        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]){
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = r - 1;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        var f = new FindMin154();
        int[] nums = {3, 1, 3};
        int ans = f.findMin2(nums);
        System.out.println(ans);
    }
}
