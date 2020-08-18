package TwoPointers;

import java.util.Stack;

/**
 * 917. 仅仅反转字母
 */
public class ReverseOnlyLetters {

    // 双指针
    public String reverseOnlyLetters(String S) {
        if (S.isEmpty()) return "";

        char[] chars = new char[S.length()];
        int l = 0;
        int r = S.length() - 1;
        while (l <= r) {
            while (l <= r && !Character.isLetter(S.charAt(l))) {
                chars[l] = S.charAt(l);
                l++;
            }
            while (l <= r && !Character.isLetter(S.charAt(r))) {
                chars[r] = S.charAt(r);
                r--;
            }

            if (l <= r) {
                char dummy = S.charAt(l);
                chars[l++] = S.charAt(r);
                chars[r--] = dummy;
            }
        }
        return new String(chars);
    }

    // 堆栈
    public String reverseOnlyLetters1(String S) {
        if (S.isEmpty()) return "";

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.add(c);
            }
        }

        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                ans.append(stack.pop());
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        var obj = new ReverseOnlyLetters();
        String ans = obj.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(ans);
    }
}
