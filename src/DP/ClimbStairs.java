package DP;

import java.util.HashMap;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {

    // 递归
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int num1;
        int num2;
        if (map.containsKey(n - 1)) {
            num1 = map.get(n - 1);
        } else {
            num1 = climbStairs(n - 1);
            map.put(n - 1, num1);
        }
        if (map.containsKey(n - 2)) {
            num2 = map.get(n - 2);
        } else {
            num2 = climbStairs(n - 2);
            map.put(n - 2, num2);
        }

        return num1 + num2;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int pre1 = 1, pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        return pre2;
    }
}
