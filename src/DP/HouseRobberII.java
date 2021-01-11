package DP;

/**
 * 213. 打家劫舍 II
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }

        return Math.max(
                rob(nums, 0, nums.length - 1),
                rob(nums, 1, nums.length)
        );
    }

    private int rob(int[] nums, int l, int r) {

        int pre2 = 0;
        int pre1 = 0;
        for (int i = l; i < r; i++) {
            int curr = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = curr;
        }

        return pre1;
    }
}
