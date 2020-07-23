package TwoPointers;

/**
 * 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int high = Integer.min(height[i], height[j]);
                int area = (j - i) * high;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    // 双指针
    public int maxArea2(int[] height) {
       int l = 0, r = height.length - 1;
       int ans = 0;

       while (l < r) {
           int high = Integer.min(height[r], height[l]);
           ans = Integer.max((r - l) * high, ans);
           if (high == height[r]) {
               r--;
           } else {
               l++;
           }
       }

       return ans;
    }
}
