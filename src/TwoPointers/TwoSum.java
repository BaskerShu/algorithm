package TwoPointers;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;

        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[] {head + 1, tail + 1};
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }

        return null;
    }
}
