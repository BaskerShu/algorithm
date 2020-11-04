package TwoPointers;

/**
 * 633. 平方数之和
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left < right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}
