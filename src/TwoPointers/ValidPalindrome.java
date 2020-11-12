package TwoPointers;

/**
 * 680. 验证回文字符串 Ⅱ
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;

//        while (head <= tail) {
//            if (s.charAt(head) == s.charAt(tail)) {
//                head++;
//                tail--;
//            } else {
//                return isPalindrome(head+1, tail, s) || isPalindrome(head, tail-1, s);
//            }
//        }
        for (; head < tail;head++, tail--) {
            if(s.charAt(head) != s.charAt(tail)) {
                return isPalindrome(head+1, tail, s) || isPalindrome(head, tail-1, s);
            }
        }
        return true;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
//            if (s.charAt(i) == s.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                return false;
//            }
        }

        return true;
    }
}
