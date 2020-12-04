package Greedy;

/**
 * 665. 非递减数列
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) return true;

        int cnt = 0;
        int numIndex = 1;
        while (numIndex < nums.length && cnt < 2) {
            if (nums[numIndex - 1] <= nums[numIndex]) {
                numIndex++;
                continue;
            }
            cnt++;
            if (numIndex - 2 >= 0 && nums[numIndex] < nums[numIndex - 2]) {
                nums[numIndex] = nums[numIndex - 1];
            } else {
                nums[numIndex - 1] = nums[numIndex];
            }
            numIndex++;
        }
        return cnt < 2;
    }
}
