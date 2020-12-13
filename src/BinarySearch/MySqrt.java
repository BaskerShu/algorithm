package BinarySearch;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 1) return 1;

        int l = 1, h = x;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int sqrt = x / m;
            if (sqrt == m) {
                return m;
            } else if (sqrt > m) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        var obj = new MySqrt();
        int ans = obj.mySqrt(8);

        System.out.println(ans);
    }
}
