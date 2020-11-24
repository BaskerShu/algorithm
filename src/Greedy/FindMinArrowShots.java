package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    // 从终点开始的贪心算法
    public int findMinArrowShotsfindMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        int prev = 0;
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[prev][1] < points[i][0]) {
                prev = i;
                count++;
            }
        }
        return count;
    }

    // 从起点开始的贪心算法
    public int findMinArrowShotsfindMinArrowShots2(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        int prev = 0;
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[prev][1] >= points[i][0]) {
                if (points[prev][1] >= points[i][1]) {
                    prev = i;
                }
            } else {
                prev = i;
                count++;

            }
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new FindMinArrowShots();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};

        int res = obj.findMinArrowShotsfindMinArrowShots(points);
        System.out.println(res);
    }
}
