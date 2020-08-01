package TwoPointers;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {

    // 1. 暴力解法
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int ans = len + 1;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(j - i + 1, ans);
                    break;
                }
            }
        }

        return ans == len + 1 ? 0 : ans;
    }

    // 2. 前缀和 + 双指针
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int ans = len + 1;
        int[] sums = new int[len+1];

        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        for (int i = 0; i < len; i++) {
            int target = sums[i] + s;
            int index = binarySearch(target, sums);
            if (index >= sums.length) {
                continue;
            }
            ans = Math.min(index - i, ans);
        }

        return ans == len + 1 ? 0 : ans;
    }

    private int binarySearch(int target, int[] sums) {
        if (sums == null || sums.length == 0) return -1;

        int l = 0;
        int r = sums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (sums[mid] == target) {
                return mid;
            } else if (sums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // 3. 双指针
    public int minSubArrayLen3(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int j = 0;
        int sum = 0;
        int ans = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                ans = Math.min(i-j+1, ans);
                sum -= nums[j];
                j++;
            }
        }

        return ans == nums.length + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        var obj = new MinSubArrayLen();
        int s = 11;
        int[] nums = {1, 2, 3, 4, 5};

        int ans = obj.minSubArrayLen3(s, nums);
        System.out.println(ans);
    }
}
