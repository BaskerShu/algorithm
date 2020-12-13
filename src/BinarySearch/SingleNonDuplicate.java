package BinarySearch;

/**
 * 540. 有序数组中的单一元素
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            boolean signal = (h - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (signal) {
                    l = mid + 2;
                } else {
                    h = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (signal) {
                    h = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate2(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        var obj = new SingleNonDuplicate();
        int ans = obj.singleNonDuplicate(nums);
        System.out.println(ans);
    }
}
