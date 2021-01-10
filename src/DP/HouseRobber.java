package DP;

/**
 * 198. 打家劫舍
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int pre2 = 0;
        int pre1 = 0;

        for (int num : nums) {
            int curr = Math.max(pre2 + num, pre1);
            pre2 = pre1;
            pre1 = curr;
        }

        return pre1;
    }
}
