package TwoPointers;

/**
 * 345. 反转字符串中的元音字母
 *
 * 元音字母是：a e i o u
 */
public class ReverseVowels {
    public static String reverseVowels(String s) {
        int sLen = s.length();
        int head = 0;
        int tail = sLen - 1;
        String h = "aeiouAEIOU";
        StringBuilder newS = new StringBuilder(s);

        while (head <= tail) {
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if (h.indexOf(headChar) != -1 && h.indexOf(tailChar) != -1) {
                newS.setCharAt(head, tailChar);
                newS.setCharAt(tail, headChar);
                head++;
                tail--;
            } else if (h.indexOf(headChar) == -1) {
                newS.setCharAt(head, headChar);
                head++;
            } else {
                newS.setCharAt(tail, tailChar);
                tail--;
            }
        }

        return newS.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String newS = reverseVowels(s);
        System.out.println(newS);
    }
}
