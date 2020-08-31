package BinarySearch;

/**
 * 852. 山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) return -1;

        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        var obj = new PeakIndexInMountainArray();
        int[] nums = {0};
        int ans = obj.peakIndexInMountainArray(nums);

        System.out.println(ans);
    }
}
