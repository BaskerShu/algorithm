package TwoPointers;

/**
 * 125. 验证回文串
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            while (l<= r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l<=r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l <= r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var obj = new IsPalindrome();
        String s = " ";
        boolean ans = obj.isPalindrome(s);

        System.out.println(ans);
    }
}
