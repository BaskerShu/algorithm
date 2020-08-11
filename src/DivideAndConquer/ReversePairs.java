package DivideAndConquer;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int len = nums.length;
        int[] copy = new int[len];
        int[] temp = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        return reversePairs(copy, 0, len, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (right - left <= 1) return 0;

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid, right, temp);

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i < right; i++) {
            temp[i] = nums[i];
        }

        int l = left;
        int r = mid;
        int crossPairs = 0;
        for (int k = left; k < right; k++) {
            if (l == mid) {
                nums[k] = temp[r++];
            } else if (r == right) {
                nums[k] = temp[l++];
            } else if (temp[r] >= temp[l]) {
                nums[k] = temp[l++];
            } else {
                nums[k] = temp[r++];
                crossPairs += mid - l;
            }
        }

        return crossPairs;
    }

    public static void main(String[] args) {
        var obj = new ReversePairs();
        int[] nums = {7, 5, 6, 4};
        int ans = obj.reversePairs(nums);

        System.out.println(ans);
    }
}
