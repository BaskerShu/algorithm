package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 */
public class EraseOverlapIntervals {

    // 从起始点开始的动态规划
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(dp[i], ans);
        }
        return intervals.length - ans;
    }

    // 从终点开始的动态规划
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    max = Math.max(dp[j], max);
                    break;
                }
            }

            dp[i] = Math.max(max+1, dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }

        return intervals.length - ans;
    }

    // 从起点开始的贪心算法
    public int eraseOverlapIntervals3(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int prev = 0;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }

        return count;
    }

    // 从终点开始的贪心算法
    public int eraseOverlapIntervals4(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    // 从终点开始的贪心算法2
    public int eraseOverlapIntervals5(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }

}
