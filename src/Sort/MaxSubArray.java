package Sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxNum = nums[0];

        for (int num : nums) {
            pre = Math.max(pre, pre + num);
            maxNum = Math.max(pre, maxNum);
        }
        return maxNum;
    }

    public int maxSubArray2(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = f[i - 1] > 0 ? nums[i] + f[i - 1] : nums[i];
        }

        return Arrays.stream(f).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        var obj = new MaxSubArray();
        int ans = obj.maxSubArray2(nums);

        System.out.println(ans);
    }
}
